# @param {Integer[]} nums
# @return {Boolean}
def contains_duplicate(nums)
  nums.sort!
  (0..nums.length - 2).each { |i| return true if nums[i] == nums[i + 1] }
  false
end