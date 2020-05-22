from typing import *


class Solution:
    def __init__(self):
        self.row = self.col = 0
        self.pre_color = self.new_color = 0

        self.image: List[List[int]] = []
        self.visit: List[List[int]] = []
        self.dx, self.dy = [-1, 1, 0, 0], [0, 0, -1, 1]

    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        self.image = image
        self.row, self.col = len(image), len(image[0])
        self.pre_color, self.new_color = image[sr][sc], newColor
        self.visit = [[False for a in range(self.col)] for b in range(self.row)]
        return self.dfs(sr, sc)

    def dfs(self, x: int, y: int) -> List[List[int]]:
        self.image[x][y] = self.new_color
        self.visit[x][y] = True

        for i in range(4):
            ax, ay = x + self.dx[i], y + self.dy[i]
            self.dfs(ax, ay) if self.can_move(ax, ay) else None

        return self.image

    def can_move(self, x: int, y: int) -> bool:
        return 0 <= x < self.row and 0 <= y < self.col \
               and not self.visit[x][y] \
               and self.image[x][y] == self.pre_color
