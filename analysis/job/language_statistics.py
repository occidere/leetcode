import os
from os import walk, path
from typing import *

import yaml

from analysis.job.job import Job
from analysis.logger.logger import *
from analysis.service.github import GitHubService
from analysis.util import encodingutils


class Language:
	def __init__(self, name: str, lang_type: str, color: str = '#D3D3D3', count: int = 0):
		self.name, self.lang_type, self.color, self.count = name, lang_type, color, count

	def __str__(self) -> str:
		return f'Language(name={self.name},lang_type={self.lang_type},color={self.color},count={self.count})'


class LanguageStatisticsJob(Job):

	def __init__(self, github_api_token: str) -> None:
		self.LANGUAGE_IMAGE_PATH = 'output/language_statistics.png'
		self.github_service = GitHubService(github_api_token)

	def run(self) -> None:
		language_criteria = self.__get_language_criteria()
		info('[Language criteria created]')
		[info(f'{k} -> {v}') for k, v in language_criteria.items()]

		language_count = self.__aggr_language_count(language_criteria)
		info('[Language usage aggregation finished]')
		[info(f'{x}') for x in language_count]

		chart_filename = self.__create_pie_chart_image(language_count)
		info('Chart image saved')

		uploaded_url = self.github_service.upload_file(
			owner='occidere',
			repo='leetcode',
			file_path=f'analysis/{chart_filename}',
			base64content=encodingutils.encode_binary_to_base64(chart_filename).decode('ascii')
		)
		info(f'Chart image uploaded as {uploaded_url}')

	def __get_language_criteria(self) -> Dict[str, Language]:
		language_yaml_content = self.github_service.get_raw_content(
			owner='github',
			repo='linguist',
			file_path='/lib/linguist/languages.yml',
			branch='master'
		)

		lang_by_ext: Dict[str, Language] = {}
		for name, specs in yaml.safe_load(language_yaml_content).items():
			lang_type: str = specs.get('type', '')
			for ext in specs.get('extensions', []):
				# programming type has top priority
				if ext not in lang_by_ext or lang_type == 'programming':
					lang_by_ext[ext] = Language(name, lang_type, specs.get('color', '#D3D3D3'))
		return lang_by_ext

	@staticmethod
	def __aggr_language_count(lang_by_ext: Dict[str, Language]) -> List[Language]:
		root_dir = path.abspath('..')
		for (root, dirs, files) in walk(root_dir):
			if path.relpath(root, root_dir)[0] != '.':
				for ext in [path.splitext(f)[1] for f in files]:
					lang_by_ext.get(ext, Language('other', 'unknown')).count += 1
		return list(filter(lambda l: l.count > 0, lang_by_ext.values()))

	def __create_pie_chart_image(self, lang_count: List[Language]) -> str:
		lang_count.sort(key=lambda lang: lang.count, reverse=True)
		counts = list(map(lambda l: l.count, lang_count))
		total_count = sum(counts)

		import matplotlib.pyplot as plt
		patches, texts, auto_texts = plt.pie(
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
		[autotext.set_color('black') for autotext in auto_texts]
		plt.tight_layout()

		plt.savefig(self.LANGUAGE_IMAGE_PATH, transparent=True)
		return self.LANGUAGE_IMAGE_PATH
