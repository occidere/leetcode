# @param {Integer[]} nums
# @return {Integer}
def rob(nums)
  nums = [0, 0] + nums
  (2...nums.length).each { |i| nums[i] = [nums[i - 1], nums[i - 2] + nums[i]].max }
  nums[-1]
end
