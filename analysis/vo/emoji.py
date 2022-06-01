class Emoji:
	"""
	https://developers.line.biz/en/docs/messaging-api/emoji-list/#line-emoji-definitions
	"""

	def __init__(self, index: int, product_id: str, emoji_id: str) -> None:
		self.index, self.product_id, self.emoji_id = index, product_id, emoji_id
