# @param {Integer} n
# @param {Integer} k
# @return {String}
def get_permutation(n, k)
  divisor, k = 1, k - 1
  nums, idx = Array.new(n) { |a| a + 1 }, Array.new(n) { |_| 0 }

  (1..n).each do |place|
    break if k / divisor == 0
    idx[n - place], divisor = (k / divisor) % place, divisor * place
  end

  idx.map { |i| nums.delete_at(i) }.join
end