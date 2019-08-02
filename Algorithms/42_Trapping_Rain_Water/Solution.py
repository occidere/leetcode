from typing import *


class Solution:

    def trap(self, height: List[int]) -> int:
        total, size = 0, len(height)
        init_max_i, init_max_h = self.get_max(height, 0, size)

        i, j = 0, init_max_i
        while i < j:
            max_i, max_h = self.get_max(height, i, j)
            total += self.get_area(height, max_i, j, max_h)
            j = max_i

        i, j = init_max_i + 1, size
        while i < j:
            max_i, max_h = self.get_max(height, i, j)
            total += self.get_area(height, i, max_i, max_h)
            i = max_i + 1

        return total

    @staticmethod
    def get_max(height: List[int], start: int, end: int) -> Tuple:
        max_i, max_h = -1, -1
        for i, h in enumerate(height[start:end]):
            if h > max_h:
            max_i, max_h = start + i, h
        return max_i, max_h

    @staticmethod
    def get_area(height: List[int], start: int, end: int, max_h: int) -> int:
        return sum([max_h - h for h in height[start:end]])
