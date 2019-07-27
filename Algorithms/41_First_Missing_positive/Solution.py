from typing import List


class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        nums = sorted(set(filter(lambda _: _ > 0, nums)))
        i = 1
        for n in nums:
            if i != n:
                break
            i += 1
        return i
