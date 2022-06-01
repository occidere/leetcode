import requests
from requests import Response


class LeetCodeService:

	def __init__(self) -> None:
		self.LEETCODE_API_URL = 'https://leetcode.com/graphql'

	def get_ranking(self, username: str) -> int:
		resp: Response = requests.post(
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
					'username': username
				}
			}
		)
		return int(resp.json()['data']['matchedUser']['profile']['ranking'])
