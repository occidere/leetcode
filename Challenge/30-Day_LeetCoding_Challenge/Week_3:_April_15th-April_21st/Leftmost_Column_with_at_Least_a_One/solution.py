from typing import *


# """
# This is BinaryMatrix's API interface.
# You should not implement it, or speculate about its implementation
# """
#
# class BinaryMatrix(object):
#     def __init__(self):
#         self.matrix = [
#             [0, 0, 1, 1],
#             [0, 1, 1, 1],
#             [0, 0, 0, 1]
#         ]
#
#     def get(self, row: int, col: int) -> int:
#         return self.matrix[row][col]
#
#     def dimensions(self) -> List[int]:
#         return [len(self.matrix), len(self.matrix[0])]


class Solution:
    def leftMostColumnWithOne(self, binaryMatrix: 'BinaryMatrix') -> int:
        rows, cols = binaryMatrix.dimensions()
        x, y = 0, cols - 1
        min_pos = -1

        while True:
            b = binaryMatrix.get(x, y)
            if b:
                min_pos = y if min_pos == -1 else min(min_pos, y)
                if self.__in_range(x, y - 1, rows, cols):
                    y -= 1
                else:  # Current column is the first column.
                    break
            else:
                if self.__in_range(x + 1, y, rows, cols):
                    x += 1
                else:  # Current row is the last row.
                    break

        return min_pos

    @staticmethod
    def __in_range(x, y, rows, cols) -> bool:
        return 0 <= x < rows and 0 <= y < cols
