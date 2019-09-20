# @param {Integer[]} nums
# @return {Integer}
def jump(nums)
  jump_count = right = max_move = 0
  nums[0..-2].each_with_index do |jumps, left|
    max_move = [max_move, left + jumps].max
    if left == right
      left, right = right, max_move
      jump_count += 1
    end
  end
  jump_count
end
