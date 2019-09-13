# @param {Integer} n
# @return {Integer}
def trailing_zeroes(n)
  k, d = 0, 5
  k, d = k + (n / d), d * 5 while d <= n
  k
end
