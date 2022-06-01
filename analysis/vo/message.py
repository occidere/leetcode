import json
from abc import ABCMeta, abstractmethod
from typing import List, Dict

from analysis.vo.emoji import Emoji


class Message:
	__metaclass__ = ABCMeta

	@abstractmethod
	def to_dict(self) -> Dict:
		raise NotImplementedError


class TextMessage(Message):
	"""
	https://developers.line.biz/en/reference/messaging-api/#text-message
	"""

	def __init__(self, text: str, emojis: List[Emoji] = None):
		self._type, self.text, self.emojis = 'text', text, emojis

	def to_dict(self) -> Dict:
		return {
			**{
				"type": "text",
				"text": self.text
			},
			**(
				{
					"emojis": self.emojis
				} if self.emojis else {}
			)
		}
		# return json.dumps({
		# 	"type": "text",
		# 	"text": self.text,
		# 	"emojis": self.emojis if self.emojis else []
		# })


class ImageMessage(Message):
	"""
	https://developers.line.biz/en/reference/messaging-api/#image-message
	"""

	def __init__(self, original_content_url: str, preview_image_url: str) -> None:
		self._type, self.original_content_url, self.preview_image_url = 'text', original_content_url, preview_image_url

	def to_dict(self) -> Dict:
		return {
			"type": "image",
			"originalContentUrl": self.original_content_url,
			"previewImageUrl": self.preview_image_url
		}
