from typing import List

import requests
from requests import Response

from analysis.logger.logger import *
from analysis.vo.message import Message


class Line:

	def __init__(self, bot_id: str, channel_access_token):
		self.bot_id, self.channel_access_token = bot_id, channel_access_token

	def send_push_message(self, messages: List[Message]) -> bool:
		try:
			resp: Response = requests.post(
				url='https://api.line.me/v2/bot/message/push',
				headers={
					'Content-Type': 'application/json',
					'Authorization': f'Bearer {self.channel_access_token}',
				},
				json={
					'to': self.bot_id,
					'messages': list(map(lambda m: m.to_dict(), messages))
				}
			)

			status_code, resp_text = resp.status_code, resp.text
			if 200 <= status_code < 300:
				info(f'Sent push message successfully')
				return True
			else:
				error(f'Failed to send push message({status_code}): {resp_text}')
		except Exception as e:
			error(f'Failed to send push message: {e}')
			return False
