from typing import List


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        i = j = 0
        l1, l2 = len(nums1), len(nums2)
        not_init = l1 - m
        while i < l1 and j < l2:
            if nums2[j] < nums1[i]:
                self.push_element(nums1, i)
                nums1[i] = nums2[j]
                j, not_init = j + 1, not_init - 1
            else:
                i += 1
                if not_init:
                nums1[i - not_init:] = nums2[j:l2]

    @staticmethod
    def push_element(nums: List[int], from_index: int) -> None:
        for k in range(len(nums) - 1, from_index, -1):
            nums[k] = nums[k - 1]
