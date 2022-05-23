import argparse
import base64
from datetime import datetime, timedelta
from pytz import timezone
from typing import *

import requests

GITHUB_API_BASE_PATH = 'https://api.github.com/repos/occidere/leetcode/contents/.statistics'
GITHUB_FILE_BASE_PATH = 'https://raw.githubusercontent.com/occidere/leetcode/master/.statistics'


class Ranking:
	def __init__(self, epoch_ms: int, ranking: int) -> None:
		self.epoch_ms = epoch_ms
		self.ranking = ranking

	def __str__(self) -> str:
		return f'Ranking({_epoch_ms_to_date_str(self.epoch_ms)},{self.ranking})'


def get_rankings_from_github() -> List[Ranking]:
	resp: requests.Response = requests.get(f'{GITHUB_FILE_BASE_PATH}/leetcode_rankings.csv')
	return [Ranking(*map(int, line.split(','))) for line in resp.iter_lines(decode_unicode=True)]


def get_ranking_from_leetcode() -> int:
	resp: requests.Response = requests.post(
		url='https://leetcode.com/graphql',
		json={
			'query': """
				query userProfile($username: String!) {
					matchedUser(username: $username) {
						profile {
							ranking
						}
					}
				}
			""",
			'variables': {
				'username': 'occidere'
			}
		}
	)
	return int(resp.json()['data']['matchedUser']['profile']['ranking'])


def upload_rankings_csv(sorted_rankings: List[Ranking], gh_token: str) -> str:
	ranking_file_url = f'{GITHUB_API_BASE_PATH}/leetcode_rankings.csv'
	auth_headers = {'Authorization': f'Bearer {gh_token}'}
	sha = requests.get(url=ranking_file_url, headers=auth_headers).json().get('sha', '')

	base64_rankings = base64.b64encode(
		'\n'.join(
			map(lambda x: f'{x.epoch_ms},{x.ranking}', sorted_rankings)
		).encode(encoding='ascii')
	)
	resp: requests.Response = requests.put(
		url=ranking_file_url,
		headers=auth_headers,
		json={
			'message': 'Update leetcode ranking csv',
			'content': f'{base64_rankings.decode("ascii")}',
			'sha': sha
		}
	)
	log(f'Upload ranking csv response: {resp}')
	return resp.json()['content']['download_url']


def generate_line_graph(rankings: List[Ranking]) -> str:
	last_10_rankings: List[Ranking] = sorted(rankings, key=lambda r: r.epoch_ms)[-10:]
	for r in last_10_rankings:
		log(f'{r}')

	xs = list(map(lambda r: _epoch_ms_to_date_str(r.epoch_ms, '%m/%d'), last_10_rankings))
	ys = list(map(lambda r: r.ranking, last_10_rankings))

	from matplotlib import pyplot as plt
	from matplotlib.offsetbox import AnchoredText

	color_val = 'orange'
	plt.figure(figsize=(9, 5), edgecolor=color_val, facecolor=color_val)
	plt.plot(xs, ys, '.-', color=color_val)
	plt.gca().invert_yaxis()
	plt.title('LeetCode Ranking', color=color_val)
	plt.xlabel('Date', color=color_val)
	plt.ylabel('Ranking', color=color_val)
	plt.tick_params(color=color_val, labelcolor=color_val, grid_color=color_val)

	for i in range(len(xs)):
		plt.text(xs[i], ys[i] + 0.3, ys[i], ha='center', va='bottom', size=10, color=color_val)

	text_box = AnchoredText(
		s=f'Updated at {_get_kst_now()} (KST)',
		frameon=False,
		loc='lower right',
		prop={'color': color_val}
	)
	plt.setp(text_box.patch, facecolor='none', alpha=0.5)
	plt.gca().add_artist(text_box)

	name = 'ranking_graph.png'
	plt.savefig(name, transparent=True)
	return name


def upload_line_graph(filename: str, gh_token) -> str:
	image_url = f'{GITHUB_API_BASE_PATH}/{filename}'
	auth_headers = {'Authorization': f'bearer {gh_token}'}
	sha = requests.get(url=image_url, headers=auth_headers).json().get('sha', '')
	resp: requests.Response = requests.put(
		url=image_url,
		headers=auth_headers,
		json={
			"message": "Update Ranking line graph",
			"content": encode_image_to_base64(filename).decode('ascii'),
			"sha": sha
		}
	)
	log(f'Upload ranking graph response: {resp}')
	return resp.json()['content']['download_url']


def encode_image_to_base64(image_path: str) -> bytes:
	with open(image_path, 'rb') as file:
		return base64.b64encode(file.read())


def send_line_notification(msg: str, graph_url: str, line_bot_id: str, line_channel_access_token: str) -> None:
	resp: requests.Response = requests.post(
		url='https://api.line.me/v2/bot/message/push',
		headers={
			'Content-Type': 'application/json',
			'Authorization': f'Bearer {line_channel_access_token}',
		},
		json={
			'to': line_bot_id,
			'messages': [
				{
					'type': 'text',
					'text': msg
				},
				{
					"type": "image",
					"originalContentUrl": graph_url,
					"previewImageUrl": graph_url
				}
			]
		}
	)
	log(f'Sent line notification ({resp})')


def log(msg: str) -> None:
	print(f'[{_get_kst_now()}] {msg}')


def _get_epoch_ms(dt: datetime = datetime.now()) -> int:
	return int(dt.timestamp() * 1000)


def _epoch_ms_to_date_str(epoch_ms: int, fmt: str = '%Y-%m-%d %H:%M:%S') -> str:
	return datetime.fromtimestamp(epoch_ms / 1000).strftime(fmt)


def _get_kst_now() -> str:
	return (datetime.utcnow() + timedelta(hours=9)).strftime("%Y-%m-%d %H:%M:%S")


if __name__ == '__main__':
	parser = argparse.ArgumentParser()
	parser.add_argument('--gh-token', help='Input GitHub API Token')
	parser.add_argument('--line-bot-id', help='Input Line Bot ID')
	parser.add_argument('--line-channel-access-token', help='Input Line Channel Access Token')
	args = parser.parse_args()

	if args.gh_token and args.line_bot_id and args.line_channel_access_token:
		# 1. Get rankings from GitHub, LeetCode
		rankings_from_github: List[Ranking] = get_rankings_from_github()
		ranking_from_leetcode: Ranking = Ranking(_get_epoch_ms(), get_ranking_from_leetcode())
		prev_rank, cur_rank = rankings_from_github[-1].ranking, ranking_from_leetcode.ranking
		log(f'prev ranking: {prev_rank}, cur ranking: {cur_rank}')

		# 2. If ranking changed,
		if prev_rank != cur_rank:
			log('Rank changed!')

			# 3. Update rankings csv to GitHub
			latest_rankings: List[Ranking] = rankings_from_github + [ranking_from_leetcode]
			upload_rankings_csv(latest_rankings, args.gh_token)

			# 4. Generate line graph
			image_name: str = generate_line_graph(latest_rankings)

			# 5. Update line graph to GitHub
			uploaded_image_url = upload_line_graph(image_name, args.gh_token)

			# 6. Send line notification with graph
			send_line_notification(
				f'Rank {"up" if prev_rank > cur_rank else "down"} ({prev_rank} -> {cur_rank})',
				uploaded_image_url,
				args.line_bot_id,
				args.line_channel_access_token
			)
		else:
			log('Rank not changed!')
	else:
		parser.print_usage()
	log('Ranking statistics job finished')
