from typing import *
from collections import defaultdict


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        cnt, acc, sum_cache = 0, 0, defaultdict(lambda: 0)
        for n in nums:
            acc += n
            cnt += (acc == k) + sum_cache[acc - k]
            sum_cache[acc] += 1
        return cnt
