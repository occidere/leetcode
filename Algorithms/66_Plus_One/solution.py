from typing import List


class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        return list(str(int(''.join(map(lambda i: str(i), digits))) + 1))
