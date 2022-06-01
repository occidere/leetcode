import base64
from typing import *

from analysis.job.job import Job
from analysis.logger.logger import info
from analysis.service.github import GitHubService
from analysis.service.leetcode import LeetCodeService
from analysis.service.line import Line
from analysis.util import dateutils, encodingutils
from analysis.vo.message import TextMessage, ImageMessage

GITHUB_API_BASE_PATH = 'https://api.github.com/repos/occidere/leetcode/contents/.statistics'
GITHUB_FILE_BASE_PATH = 'https://raw.githubusercontent.com/occidere/leetcode/master/.statistics'


class Ranking:
	def __init__(self, epoch_ms: int, ranking: int) -> None:
		self.epoch_ms = epoch_ms
		self.ranking = ranking

	def __str__(self) -> str:
		return f'Ranking({dateutils.epoch_ms_to_date_str(self.epoch_ms)},{self.ranking})'


class LeetCodeRankingJob(Job):

	def __init__(self, github_api_token: str, line_bot_id: str, line_channel_access_token: str) -> None:
		self.github_api_token = github_api_token
		self.github_service = GitHubService(github_api_token)
		self.leetcode_service = LeetCodeService()
		self.line_service = Line(line_bot_id, line_channel_access_token)
		self.LEETCODE_RANKING_GRAPH_PATH = 'analysis/output/ranking_graph.png'
		self.LEETCODE_RANKING_CSV_PATH = 'analysis/output/leetcode_rankings.csv'

	def run(self) -> None:
		# 1. Get rankings from GitHub, LeetCode
		rankings_from_github: List[Ranking] = self.get_rankings_from_github()
		ranking_from_leetcode: Ranking = Ranking(dateutils.get_epoch_ms(),
												 self.leetcode_service.get_ranking('occidere'))
		prev_rank, cur_rank = rankings_from_github[-1].ranking, ranking_from_leetcode.ranking
		info(f'prev ranking: {prev_rank}, cur ranking: {cur_rank}')

		# 2. If ranking changed,
		if prev_rank != cur_rank:
			info('Rank changed!')

			# 3. Update rankings csv to GitHub
			latest_rankings: List[Ranking] = rankings_from_github + [ranking_from_leetcode]
			self.upload_rankings_csv(latest_rankings)

			# 4. Generate line graph
			image_path: str = self.generate_line_graph(latest_rankings)

			# 5. Update line graph to GitHub
			uploaded_image_url = self.upload_line_graph(image_path)

			# # 6. Send line notification with graph
			self.send_line_notification(
				f'Rank {"up" if prev_rank > cur_rank else "down"} ({prev_rank} -> {cur_rank})',
				uploaded_image_url
			)
		else:
			info('Rank not changed!')
		info('Ranking analysis job finished')

	def get_rankings_from_github(self) -> List[Ranking]:
		content: bytes = self.github_service.get_raw_content(
			owner='occidere',
			repo='leetcode',
			file_path=self.LEETCODE_RANKING_CSV_PATH,
			branch='master'
		)
		return [
			Ranking(*map(int, line.split(','))) for line in
			filter(
				lambda x: len(x) > 0, content.decode(encoding='ascii').split('\n')
			)
		]

	def upload_rankings_csv(self, sorted_rankings: List[Ranking]) -> str:
		return self.github_service.upload_file(
			owner='occidere',
			repo='leetcode',
			file_path='analysis/output/leetcode_rankings.csv',
			base64content=base64.b64encode(
				'\n'.join(
					map(lambda x: f'{x.epoch_ms},{x.ranking}', sorted_rankings)
				).encode(encoding='ascii')
			).decode('ascii')
		)

	def generate_line_graph(self, rankings: List[Ranking]) -> str:
		last_10_rankings: List[Ranking] = sorted(rankings, key=lambda r: r.epoch_ms)[-10:]
		for r in last_10_rankings:
			info(f'{r}')

		xs = list(map(lambda r: dateutils.epoch_ms_to_date_str(r.epoch_ms, '%m/%d'), last_10_rankings))
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
			s=f'Updated at {dateutils.get_kst_now()} (KST)',
			frameon=False,
			loc='lower right',
			prop={'color': color_val}
		)
		plt.setp(text_box.patch, facecolor='none', alpha=0.5)
		plt.gca().add_artist(text_box)

		plt.savefig(self.LEETCODE_RANKING_GRAPH_PATH, transparent=True)
		return self.LEETCODE_RANKING_GRAPH_PATH

	def upload_line_graph(self, file_path: str) -> str:
		uploaded_url = self.github_service.upload_file(
			owner='occidere',
			repo='leetcode',
			file_path=file_path,
			base64content=encodingutils.encode_binary_to_base64(file_path).decode('ascii')
		)
		info(f'Uploaded ranking graph to {uploaded_url}')
		return uploaded_url

	def encode_image_to_base64(self, image_path: str) -> bytes:
		with open(image_path, 'rb') as file:
			return base64.b64encode(file.read())

	def send_line_notification(self, msg: str, graph_url: str) -> None:
		resp: bool = self.line_service.send_push_message(
			[
				TextMessage(text=msg),
				ImageMessage(original_content_url=graph_url, preview_image_url=graph_url)
			]
		)
		info(f'Sent line notification ({resp})')
