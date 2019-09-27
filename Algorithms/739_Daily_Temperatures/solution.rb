# @param {Integer[]} t
# @return {Integer[]}
def daily_temperatures(t)
  stk, ans = [0], Array.new(t.length) { |_| 0 }
  (1...t.length).each do |i|
    ans[stk[-1]] = i - stk.pop while !stk.empty? and t[stk[-1]] < t[i]
    stk << i
  end
  ans
end