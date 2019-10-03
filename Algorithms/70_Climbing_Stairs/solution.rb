# @param {Integer} n
# @return {Integer}
def climb_stairs(n)
  a = b = 1
  (2..n).each { |_| a, b = b, a + b }
  b
end