from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        return len([x for x in nums if x < target])
