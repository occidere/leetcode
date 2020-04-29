from typing import *


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        right, res = 1, [1 for _ in range(len(nums))]
        for i in range(1, len(nums)):
            res[i] *= nums[i - 1] * res[i - 1]
        for i in range(len(nums) - 2, -1, -1):
            res[i] *= nums[i + 1] * right
            right *= nums[i + 1]
        return res
