# @param {Integer} n
# @param {Integer} k
# @return {Integer[][]}
def combine(n, k)
  Combine.new(n, k).ans
end

class Combine
  attr_reader :ans

  def initialize(n, k)
    @n, @k = n, k
    @arr, @ans = Array.new(n) { |_| _ + 1 }, []
    dfs(-1, [])
  end

  private

  def dfs(cur, selected)
    if selected.length == @k
      @ans << selected.dup
      return
    end
    (cur + 1...@n).each { |i| dfs(i, selected + [@arr[i]]) }
  end
end