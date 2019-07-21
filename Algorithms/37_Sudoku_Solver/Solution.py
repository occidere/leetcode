from typing import List
from copy import deepcopy


class Solution:

    def __init__(self):
        self.vertical = [0, 0, 0, 0, 0, 0, 0, 0, 0]
        self.horizontal = [0, 0, 0, 0, 0, 0, 0, 0, 0]
        self.box = [[0, 0, 0], [0, 0, 0], [0, 0, 0]]

        self.blank: List[tuple] = []
        self.blank_len = 0

        self.ans: List[List[str]] = []
        self.is_finished = False

    def solveSudoku(self, board: List[List[str]]) -> None:
        for i, row in enumerate(board):
            for j, num in enumerate(row):
                if num == '.':
                    self.blank.append((i, j))
                    self.blank_len += 1
                else:
                    self.mark(board, i, j, int(num) - 1)

        self.dfs(board, 0)
        for i, row in enumerate(self.ans):
            board[i] = row

    def dfs(self, board: List[List[str]], cur_index: int) -> None:
        if cur_index >= self.blank_len:
            self.ans = deepcopy(board)
            self.is_finished = True
            return

        x, y = self.blank[cur_index]
        for n in range(0, 9):
            if not self.is_finished and self.is_valid(x, y, n):
                self.mark(board, x, y, n)
                self.dfs(board, cur_index + 1)
                self.mark(board, x, y, n, True)

    def is_valid(self, x: int, y: int, n: int) -> bool:
        pos = 1 << n
        return not (self.vertical[y] & pos or
                    self.horizontal[x] & pos or
                    self.box[int(x / 3)][int(y / 3)] & pos)

    def mark(self, board: List[List[str]], x: int, y: int, n: int, undo: bool = False) -> None:
        pos = 1 << n
        if undo:
            self.vertical[y] ^= pos
            self.horizontal[x] ^= pos
            self.box[int(x / 3)][int(y / 3)] ^= pos
            board[x][y] = '.'
        else:
            self.vertical[y] |= pos
            self.horizontal[x] |= pos
            self.box[int(x / 3)][int(y / 3)] |= pos
            board[x][y] = str(n + 1)
