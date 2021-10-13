/**
 * @param {character[][]} board
 * @return {number}
 */
const numRookCaptures = board => {
  Array.prototype.move = function (dx, dy) {
    let [x, y] = this;
    while ((0 <= x && x < 8) && (0 <= y && y < 8)) {
      switch (board[x][y].toString()) {
        case "p":
          return 1;
        case "B":
          return 0;
        default:
          x += dx;
          y += dy;
      }
    }
    return 0;
  }

  for (let i = 0; i < 8; ++i) {
    for (let j = 0; j < 8; ++j) {
      if (board[i][j].toString() === "R") {
        const rook = [i, j];
        return rook.move(-1, 0) + rook.move(1, 0) + rook.move(0, -1) + rook.move(0, 1);
      }
    }
  }
  return 0;
};
