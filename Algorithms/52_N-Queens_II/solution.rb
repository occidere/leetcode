# @param {Integer} n
# @return {Integer}
def total_n_queens(n)
  Chess.new(n).ans.length
end

class Chess

  attr_reader :ans

  def initialize(size)
    @size, @ans = size, []
    @board = Array.new(size) { |i| Array.new(size) { |j| '.' } }
    dfs 0
  end

  private

  def dfs(x)
    if x == @size
      @ans << copy_board
      return
    end

    (0...@size).each do |i|
      @board[x][i] = 'Q'
      dfs(x + 1) if check(x, i)
      @board[x][i] = '.'
    end
  end

  def check(x, y)
    (0...x).each { |i| return false if @board[i][y] == 'Q' }
    j = 1
    while x >= j
      return false if j <= y and @board[x - j][y - j] == 'Q'
      return false if y <= @size - j and @board[x - j][y + j] == 'Q'
      j += 1
    end
    true
  end

  def copy_board
    ret = []
    @board.each { |b| ret << b.join }
    ret
  end
end