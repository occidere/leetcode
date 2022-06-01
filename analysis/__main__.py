import argparse

from logger.logger import error
from job.language_statistics import LanguageStatisticsJob
from job.leetcode_ranking import LeetCodeRankingJob

if __name__ == '__main__':
	parser = argparse.ArgumentParser()
	parser.add_argument('--job', help='Job name')
	parser.add_argument('--github-api-token', help='Input GitHub API Token')
	parser.add_argument('--line-bot-id', help='Line bot ID to send push message')
	parser.add_argument('--line-channel-access-token', help='Line channel access token to send push message')
	args = parser.parse_args()

	job_name = args.job
	if job_name == 'LanguageStatisticsJob':
		LanguageStatisticsJob(args.github_api_token).run()
	elif job_name == 'LeetCodeRankingJob':
		LeetCodeRankingJob(
			args.github_api_token,
			args.line_bot_id,
			args.line_channel_access_token
		).run()
	else:
		error(f'No such job: {job_name}')
