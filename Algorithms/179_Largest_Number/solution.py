from itertools import dropwhile
from typing import *


class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        return ''.join(dropwhile(lambda c: c == '0', sorted(map(str, nums), key=self.SortFunc))) or '0'

    class SortFunc(str):
        def __lt__(x, y) -> bool:
            return x + y > y + x
