import requests
from requests import Response

from analysis.logger.logger import info


class GitHubService:

	def __init__(self, github_api_token: str) -> None:
		self.github_api_token = github_api_token
		self.GITHUB_API_BASE_URL = 'https://api.github.com'
		self.GITHUB_LEETCODE_ANALYSIS_PATH = 'repos/occidere/leetcode/contents/analysis'
		self.GITHUB_API_RAW_BASE_URL = 'https://raw.githubusercontent.com'

	def get_sha(self, file_url: str) -> str:
		auth_headers = {'Authorization': f'bearer {self.github_api_token}'}
		return requests.get(url=file_url, headers=auth_headers).json().get('sha', '')

	def upload_file(self, owner: str, repo: str, file_path: str, base64content: str) -> str:
		file_url = f'{self.GITHUB_API_BASE_URL}/repos/{owner}/{repo}/contents/{file_path}'
		auth_headers = {'Authorization': f'bearer {self.github_api_token}'}
		sha = self.get_sha(file_url)
		info(f'sha: {sha}')

		resp: Response = requests.put(
			url=file_url,
			headers=auth_headers,
			json={
				"message": "Upload file",
				"content": base64content,
				"sha": sha
			}
		)
		info(f'Upload file response: {resp}')
		return resp.json()['content']['download_url']

	def get_raw_content(self, owner: str, repo: str, file_path: str, branch: str = 'main') -> bytes:
		resp: Response = requests.get(f'{self.GITHUB_API_RAW_BASE_URL}/{owner}/{repo}/{branch}/{file_path}')
		return resp.content
