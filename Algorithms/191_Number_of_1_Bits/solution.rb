# @param {Integer} n, a positive integer
# @return {Integer}
def hamming_weight(n)
  n.to_s(2).split("").inject(0) {|sum, x| sum + x.to_i}
end
