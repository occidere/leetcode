def longest_common_prefix(strs)
  strs = strs.sort_by(&:length)
  lcp = strs[0]

  (1...strs.length).each do |i|
    min_len = [lcp.length, strs[i].length].min
    (0...min_len).each do |j|
      if lcp[j].chr != strs[i][j].chr
        lcp = j.zero? ? '' : lcp[0..j - 1]
        break
      end
    end
  end
  lcp.nil? ? '' : lcp
end
