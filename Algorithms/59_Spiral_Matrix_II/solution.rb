# @param {Integer} n
# @return {Integer[][]}
def generate_matrix(n)
  Matrix.new.solve n
end

class Matrix
  def initialize
    @coordinate, @direction = {
        0 => [0, 1], # right
        1 => [1, 0], # down
        2 => [0, -1], # left
        3 => [-1, 0] # up
    }, 0
  end

  def solve(n)
    @arr = Array.new(n) { |a| Array.new(n) { |b| 0 } }
    x, y = 0, 0
    dx, dy = @coordinate[@direction]

    (n * n).times.each do |i|
      @arr[x][y] = i + 1
      dx, dy = change_direction if should_change_direction(x + dx, y + dy, n)
      x, y = x + dx, y + dy
    end

    @arr
  end

  def should_change_direction(ax, ay, n)
    ax >= n or ay >= n or @arr[ax][ay] != 0
  end

  def change_direction
    @coordinate[@direction = (@direction + 1) % 4]
  end
end