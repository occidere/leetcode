# @param {String} s
# @return {Integer}
def title_to_number(s)
  len, num = s.length - 1, 0
  s.split('').each_with_index do |c, i|
    num += len > i ? (26 ** (len - i)) * (c.ord - 64) : c.ord - 64
  end
  num
end
