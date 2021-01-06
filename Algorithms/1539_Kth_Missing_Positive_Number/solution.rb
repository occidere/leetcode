require 'set'

# @param {Integer[]} arr
# @param {Integer} k
# @return {Integer}
def find_kth_positive(arr, k)
  set, cnt = arr.uniq.to_set, 0
  (1..2000).each { |i|
    cnt += set.include?(i) ? 0 : 1
    if cnt == k
      return i
    end
  }
  0
end
