# @param {Integer[]} nums
# @return {Integer[][]}
def subsets(nums)
  Subset.new(nums).subset
end

class Subset
  attr_reader :subset

  def initialize(nums)
    @nums, @len, @subset = nums, nums.length, []
    dfs(-1, [])
  end

  private

  def dfs(cur, selected)
    @subset << selected.dup
    return if selected.length == @len
    (cur + 1...@len).each { |i| dfs(i, selected + [@nums[i]]) }
  end
end