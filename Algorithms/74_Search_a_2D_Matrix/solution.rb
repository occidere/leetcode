# @param {Integer[][]} matrix
# @param {Integer} target
# @return {Boolean}
def search_matrix(matrix, target)
  b_search(matrix.flatten, target)
end

def b_search(a, t)
  return false if a.empty?
  a[m = a.length / 2] == t ? true : (a[m] > t ? b_search(a[0...m], t) : b_search(a[m + 1..-1], t))
end