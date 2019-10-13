# @param {Integer[]} nums
# @return {Integer}
def remove_duplicates(nums)
  i, len = 1, nums.length
  while i < len - 1
    l, m, r = nums[i - 1], nums[i], nums[i + 1]
    if l == m and m == r
      (i + 2...len).each { |j| nums[j - 1] = nums[j] }
      nums[(len  = len - 1)] = nil
    else
      i += 1
    end
  end
  len
end