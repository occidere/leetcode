from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        b = 0
        for k in nums:
          b ^= k
        return b
