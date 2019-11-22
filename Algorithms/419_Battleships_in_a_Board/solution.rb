# @param {Character[][]} board
# @return {Integer}
def count_battleships(board)
  cnt = 0
  (0...board.length).each do |i|
    (0...board[0].length).each do |j|
      cnt += 1 if is_first_part?(board, i, j)
    end
  end
  cnt
end

def is_first_part?(board, i, j)
  left, up = j > 0 ? board[i][j - 1] : '.', i > 0 ? board[i - 1][j] : '.'
  board[i][j] == 'X' and left == '.' and up == '.'
end