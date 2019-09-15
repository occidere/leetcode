# @param {Integer[]} nums
# @param {Integer} k
# @return {Void} Do not return anything, modify nums in-place instead.
def rotate(nums, k)
  k %= nums.length
  nums.replace(nums[-k..-1] + (k > 0 ? nums[0..-1 - k] : []))
end
