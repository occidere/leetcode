from typing import *


class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        pos_of_val = {0: -1}
        max_len, val = 0, 0

        for cur_pos, n in enumerate(nums, 1):
            val += 1 if n else -1
            if val in pos_of_val:
                max_len = max(max_len, cur_pos - pos_of_val[val])
            else:
                pos_of_val[val] = cur_pos

        return max_len
