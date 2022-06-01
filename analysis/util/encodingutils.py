import base64


def encode_binary_to_base64(file_path: str) -> bytes:
	with open(file_path, 'rb') as file:
		return base64.b64encode(file.read())
