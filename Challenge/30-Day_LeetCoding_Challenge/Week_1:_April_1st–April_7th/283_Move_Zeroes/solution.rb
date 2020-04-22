# @param {Integer[]} nums
# @return {Void} Do not return anything, modify nums in-place instead.
def move_zeroes(nums)
  (l = 0...nums.length).each do |r|
    if nums[l] == 0 and nums[r] != 0
      nums[l], nums[r] = nums[r], nums[l]
      l += 1
    elsif nums[l] != 0 and nums[r] == 0
      l = r
    end
  end
end