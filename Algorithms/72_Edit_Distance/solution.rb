# @param {String} word1
# @param {String} word2
# @return {Integer}
def min_distance(word1, word2)
  n, m = word1.length, word2.length
  dp = Array.new(n + 1) { |i| Array.new(m + 1) { |j| 0 } }
  (0..n).each { |i| dp[i][0] = i }
  (0..m).each { |j| dp[0][j] = j }

  (1..n).each do |i|
    (1..m).each do |j|
      dp[i][j] = word1[i - 1] == word2[j - 1] ? dp[i - 1][j - 1] : [dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]].min + 1
    end
  end

  dp[-1][-1]
end