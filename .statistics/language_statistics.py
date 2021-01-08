import argparse
import base64
from datetime import datetime
from os import walk, path
from typing import *

import requests
import yaml


class Language:
    def __init__(self, name: str, lang_type: str, color: str = '#D3D3D3', count: int = 0):
        self.name, self.lang_type, self.color, self.count = name, lang_type, color, count

    def __str__(self) -> str:
        return f'Language(name={self.name},lang_type={self.lang_type},color={self.color},count={self.count})'


def get_language_criteria() -> Dict[str, Language]:
    resp: requests.Response = requests.get(
        'https://raw.githubusercontent.com/github/linguist/master/lib/linguist/languages.yml')
    log('Languages yaml response: {}'.format(resp))
    lang_by_ext: Dict[str, Language] = {}
    for name, specs in yaml.safe_load(resp.content).items():
        lang_type: str = specs.get('type', '')
        for ext in specs.get('extensions', []):
            # programming type is top priority
            if ext not in lang_by_ext or lang_type == 'programming':
                lang_by_ext[ext] = Language(
                    name=name,
                    lang_type=lang_type,
                    color=specs.get('color', '#D3D3D3')
                )
    return lang_by_ext


def aggr_language_count(lang_by_ext: Dict[str, Language]) -> List[Language]:
    root_dir = path.abspath('..')
    for (root, dirs, files) in walk(root_dir):
        if path.relpath(root, root_dir)[0] != '.':
            for ext in [path.splitext(f)[1] for f in files]:
                lang_by_ext.get(ext, Language('other', 'unknown')).count += 1
    return list(filter(lambda l: l.count > 0, lang_by_ext.values()))


def create_pie_chart_image(lang_count: List[Language]) -> str:
    lang_count.sort(key=lambda lang: lang.count, reverse=True)
    counts = list(map(lambda l: l.count, lang_count))
    total_count = sum(counts)

    import matplotlib.pyplot as plt
    pathches, texts, autotexts = plt.pie(
        x=[c / total_count for c in counts],
        colors=[lang.color for lang in lang_count],
        autopct='%1.1f%%',
        startangle=0
    )
    plt.suptitle('Languages Statistics', fontsize=15, x=.45, color='grey')
    plt.legend(
        ['{} ({})'.format(lang.name, lang.count) for lang in lang_count],
        loc='upper right',
        bbox_to_anchor=(1.3, 1.1)
    )
    [text.set_color('black') for text in texts]
    [autotext.set_color('black') for autotext in autotexts]
    plt.tight_layout()

    image_name = 'language_statistics.png'
    plt.savefig(image_name, transparent=True)
    return image_name


def upload_pie_chart(filename: str, github_api_token) -> str:
    image_url = 'https://api.github.com/repos/occidere/leetcode/contents/.statistics/{}'.format(filename)
    auth_headers = {'Authorization': 'bearer {}'.format(github_api_token)}
    sha = requests.get(url=image_url, headers=auth_headers).json().get('sha', '')
    resp: requests.Response = requests.put(
        url=image_url,
        headers=auth_headers,
        json={
            "message": "Update languages statistics chart",
            "content": encode_image_to_base64(filename).decode('ascii'),
            "sha": sha
        }
    )
    log('Upload image response: {}'.format(resp))
    return resp.json()['content']['download_url']


def encode_image_to_base64(image_path: str) -> bytes:
    with open(image_path, 'rb') as file:
        return base64.b64encode(file.read())


def log(msg: str) -> None:
    print('[{}] {}'.format(datetime.now().strftime('%Y-%m-%d %H:%M:%S'), msg))


if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument('--token', help='Input GitHub API Token')
    args = parser.parse_args()
    if args.token:
        language_criteria = get_language_criteria()
        log('[Language criteria created]')
        [log(f'{k} -> {v}') for k, v in language_criteria.items()]

        language_count = aggr_language_count(language_criteria)
        log('[Language usage aggregation finished]')
        [log(f'{x}') for x in language_count]

        # chart_filename = create_pie_chart_image(language_count)
        # log('Chart image saved')
        #
        # uploaded_url = upload_pie_chart(chart_filename, args.token)
        # log('Chart image uploaded')
    else:
        parser.print_usage()
