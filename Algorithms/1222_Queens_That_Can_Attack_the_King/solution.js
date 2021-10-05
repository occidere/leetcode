/**
 * @param {number[][]} queens
 * @param {number[]} king
 * @return {number[][]}
 */
const queensAttacktheKing = (queens, king) => {
  const board = new Array(8);
  for (let i = 0; i < 8; ++i) {
    board[i] = [0, 0, 0, 0, 0, 0, 0, 0];
  }
  queens.forEach(q => board[q[0]][q[1]] = 1);

  const move = (x, y, dx, dy) => {
    while ((0 <= x && x < 8) && (0 <= y && y < 8)) {
      if (board[x][y] === 1) {
        return [x, y];
      }
      x += dx;
      y += dy;
    }
    return [-1, -1];
  };

  return [[-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1], [0, -1], [-1, -1]]
    .map(xy => move(...king, ...xy))
    .filter(xy => xy[0] >= 0 && xy[1] >= 0);
};
