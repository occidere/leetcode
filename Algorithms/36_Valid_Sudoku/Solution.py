from typing import List


class Solution:

    def __init__(self):
        self.vertical = [0, 0, 0, 0, 0, 0, 0, 0, 0]
        self.horizontal = [0, 0, 0, 0, 0, 0, 0, 0, 0]
        self.area = [[0, 0, 0], [0, 0, 0], [0, 0, 0]]

    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for i, row in enumerate(board):
            for j, num in enumerate(row):
                if num != '.' and not self.check_visit(i, j, int(num) - 1):
                    return False
        return True

    def check_visit(self, x: int, y: int, n: int) -> bool:
        pos = (1 << n)
        if self.vertical[x] & pos:
            return False
        else:
            self.vertical[x] |= pos

        if self.horizontal[y] & pos:
            return False
        else:
            self.horizontal[y] |= pos

        if self.area[int(x / 3)][int(y / 3)] & pos:
            return False
        else:
            self.area[int(x / 3)][int(y / 3)] |= pos

        return True
