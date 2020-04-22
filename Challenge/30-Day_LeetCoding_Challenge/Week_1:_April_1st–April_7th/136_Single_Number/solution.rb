# @param {Integer[]} nums
# @return {Integer}
def single_number(nums)
  a = 0
  nums.each { |n| a ^= n }
  a
end