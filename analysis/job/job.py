from abc import ABCMeta, abstractmethod


class Job:
	__metaclass__ = ABCMeta

	@abstractmethod
	def run(self):
		raise NotImplementedError
