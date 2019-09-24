# @param {Integer[][]} matrix
# @return {Integer[]}
def spiral_order(matrix)
  if !matrix or matrix.length == 0
    return []
  end

  direction, coordinate = 0, {
      0 => [0, 1], # right
      1 => [1, 0], # down
      2 => [0, -1], # left
      3 => [-1, 0] # up
  }

  spiral = []
  x, y = 0, 0
  dx, dy = coordinate[direction]
  width, height = matrix[0].length, matrix.length

  (width * height).times do |_|
    spiral << matrix[x][y]
    matrix[x][y] = nil

    if x + dx >= height or y + dy >= width or matrix[x + dx][y + dy] == nil
      direction, dx, dy = change_direction(direction, coordinate)
    end

    x, y = x + dx, y + dy
  end

  spiral
end

def change_direction(direction, coordinate)
  direction = (direction + 1) % 4
  [direction] + coordinate[direction]
end