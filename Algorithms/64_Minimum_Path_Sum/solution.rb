# @param {Integer[][]} grid
# @return {Integer}
def min_path_sum(grid)
  (0..grid[0].length - 2).each { |i| grid[0][i + 1] += grid[0][i] }
  (0..grid.length - 2).each { |i| grid[i + 1][0] += grid[i][0] }
  (1..grid.length - 1).each { |i| (1..grid[0].length - 1).each { |j| grid[i][j] += [grid[i - 1][j], grid[i][j - 1]].min } }
  grid[-1][-1]
end