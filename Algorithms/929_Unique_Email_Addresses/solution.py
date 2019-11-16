from typing import *


class Solution:
	def numUniqueEmails(self, emails: List[str]) -> int:
		processed_sets: Set[str] = set()
		for local, domain in map(lambda e: e.split('@'), emails):
			local = local.replace('.', '')
			plus = local.find('+')
			if plus != -1:
				local = local[0:plus]
			processed_sets.add('{}@{}'.format(local, domain))
		return len(processed_sets)
