class SparseVector
  attr_reader :nums

=begin
    :type nums: Integer[]
=end
  def initialize(nums)
    @nums = nums
  end

  # Return the dotProduct of two sparse vectors
=begin
    :type vec: SparseVector
    :rtype: Integer
=end
  def dotProduct(vec)
    acc = 0
    @nums.each_with_index { |v, i| acc += v * vec.nums[i] }
    acc
  end
end

# Your SparseVector object will be instantiated and called as such:
# v1 = SparseVector.new(nums1)
# v2 = SparseVector.new(nums2)
# ans = v1.dotProduct(v2)
