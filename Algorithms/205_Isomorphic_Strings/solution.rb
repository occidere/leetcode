# @param {String} s
# @param {String} t
# @return {Boolean}
def is_isomorphic(s, t)
  a, b = [], []
  (0...s.length).each do |i|
    sc, tc = s[i].ord, t[i].ord
    return false if a[sc] != b[tc]
    a[sc], b[tc] = i + 1, i + 1
  end
  true
end