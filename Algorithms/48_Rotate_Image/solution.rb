# @param {Integer[][]} matrix
# @return {Void} Do not return anything, modify matrix in-place instead.
def rotate(matrix)
  matrix, n = matrix.reverse!, matrix.length
  (0...n).each do |i|
    (i + 1...n).each do |j|
      matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
    end
  end
end
