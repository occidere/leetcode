# @param {Integer} n
# @return {Boolean}
def is_happy(n)
  visit = {}
  visit[n] = n = n.to_s.each_char.inject(0) { |sum, s| sum + (s.to_i ** 2) } while n != 1 and !visit[n]
  n == 1
end
