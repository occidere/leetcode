# @param {Integer[]} numbers
# @param {Integer} target
# @return {Integer[]}
def two_sum(numbers, target)
  i, j = 0, numbers.length - 1
  while i < j
    k = numbers[i] + numbers[j]
    if k == target
      return i + 1, j + 1
    elsif k < target
      i += 1
    else
      j -= 1
    end
  end
end
