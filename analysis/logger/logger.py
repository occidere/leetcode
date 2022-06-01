from analysis.util.dateutils import get_kst_now


def info(msg: str) -> None:
	__log('INFO', msg)


def warn(msg: str) -> None:
	__log('WARN', msg)


def error(msg: str) -> None:
	__log('ERROR', msg)


def __log(level: str, msg: str) -> None:
	print(f'[{get_kst_now()}] {level} {msg}')
