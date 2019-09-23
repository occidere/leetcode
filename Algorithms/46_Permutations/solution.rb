# @param {Integer[]} nums
# @return {Integer[][]}
def permute(nums)
  permutations = Hash.new(0)
  dfs(nums, Array.new(nums.length) { |_| false }, [], permutations)
  permutations.keys
end

def dfs(nums, visit, selected, permutations)
  if selected.length == nums.length
    permutations[selected.dup] += 1
    return
  end

  nums.each_with_index do |n, i|
    unless visit[i]
      visit[i] = true
      selected << n
      dfs(nums, visit, selected, permutations)
      selected.pop
      visit[i] = false
    end
  end
end
