from typing import List


class Solution:

    def __init__(self):
	self.ans: List[List[int]] = []
	self.c: List[int] = []
	self.target: int = 0

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.target = target
        self.c = candidates
        self.dfs(0, 0, [])
        return self.ans

    def dfs(self, cur: int, acc: int, select: List[int]):
	if acc >= self.target:
	    if acc == self.target:
		self.ans.append(select)
	    return

	for i in range(cur, len(self.c)):
	    self.dfs(i, acc + self.c[i], select + [self.c[i]])
