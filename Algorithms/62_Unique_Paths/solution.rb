# @param {Integer} m
# @param {Integer} n
# @return {Integer}
def unique_paths(m, n)
  a = Array.new(m) { |_| 1 }
  (n - 1).times.each do |_|
    b = Array.new(m) { |i| i == 0 ? 1 : 0 }
    (1...m).each { |i| b[i] = b[i - 1] + a[i] }
    a = b
  end
  a[-1]
end