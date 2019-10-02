# @param {Integer} m
# @param {Integer} n
# @return {Integer}
def unique_paths_with_obstacles(obstacle_grid)
  obstacle_grid.each { |g| g.map! { |_| _ *= -1 } }
  obstacle_grid[0].each_with_index do |n, i|
    if n == -1
      obstacle_grid[0] = obstacle_grid[0][0..i] + Array.new(obstacle_grid[0].length - (i + 1)) { |_| -1 }
      break
    end
    obstacle_grid[0][i] = 1
  end

  (1...obstacle_grid.length).each do |i|
    obstacle_grid[i][0] = 1 if obstacle_grid[i][0] != -1 and obstacle_grid[i - 1][0] > 0
    (1...obstacle_grid[i].length).each do |j|
      cur, up, left = obstacle_grid[i][j], obstacle_grid[i - 1][j], obstacle_grid[i][j - 1]
      obstacle_grid[i][j] += ((left != -1 ? left : 0) + (up != -1 ? up : 0)) if cur != -1
    end
  end

  obstacle_grid[-1][-1] == -1 ? 0 : obstacle_grid[-1][-1]
end


