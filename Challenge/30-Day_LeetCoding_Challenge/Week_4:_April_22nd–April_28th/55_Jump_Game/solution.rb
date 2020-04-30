# @param {Integer[]} nums
# @return {Boolean}
def can_jump(nums)
  unreachable = 0
  nums[0..-2].reverse_each do |n|
    unreachable = if n == 0
                    unreachable + 1
                  else
                    n > unreachable ? 0 : unreachable + 1
                  end
  end
  unreachable == 0
end
