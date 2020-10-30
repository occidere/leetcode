from typing import *


class Solution:
    def checkArithmeticSubarrays(self, nums: List[int], l: List[int], r: List[int]) -> List[bool]:
        return [len(set(map(lambda ys: ys[0] - ys[1], zip(xs, xs[1:])))) == 1 for xs in [sorted(nums[i:j + 1]) for i, j in zip(l, r)]]
