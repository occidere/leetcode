from typing import List, Set


class Solution:

    def __init__(self):
        self.ans: List[List[int]] = []
        self.candidates: List[int] = []
        self.cache: Set[str] = set()
        self.target: int = 0

    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        self.candidates = candidates
        self.target = target
        self.candidates.sort()
        self.dfs(-1, 0, [])
        return self.ans

    def dfs(self, cur: int, acc: int, selected: List[int]) -> None:
        if acc >= self.target:
            if acc == self.target and str(selected) not in self.cache:
                self.cache.add(str(selected))
                self.ans.append(selected)
            return

        for i in range(cur + 1, len(self.candidates)):
            n = self.candidates[i]
            self.dfs(i, acc + n, selected + [n])
