from typing import List


class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        rows: List[List[int]] = [[1]]
        for i in range(1, numRows):
            rows.append([1] + [(rows[i - 1][j - 1] + rows[i - 1][j]) for j in range(1, len(rows[i - 1]))] + [1])
        return [] if numRows == 0 else rows
