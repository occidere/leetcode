from typing import List


class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        a, b = [1], []
        for i in range(1, rowIndex + 1):
            b = [1] + [(a[j - 1] + a[j]) for j in range(1, len(a))] + [1]
            a = b
        return a
