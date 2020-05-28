# @param {Integer} num
# @return {Integer[]}
def count_bits(num)
  Tree.new(num).trace
end

class Tree

  attr_reader :trace

  def initialize(size)
    @trace = Array.new(size, 0)
    root = Node.new(0)

    build_tree(root, size)
    dfs(root, 1) if size > 0

    @trace = [0] + @trace
  end

  private

  def build_tree(root, size)
    q = [root]
    k = 1

    while k < size
      node = q.shift
      k < size ? (q.push(node.left = Node.new(k)); k += 1) : break
      k < size ? (q.push(node.right = Node.new(k)); k += 1) : break
    end
  end

  def dfs(node, sum)
    return unless node

    @trace[node.idx] = sum
    dfs(node.left, sum)
    dfs(node.right, sum + 1)
  end

end

class Node

  attr_reader :idx
  attr_accessor :left, :right

  def initialize(idx)
    @idx = idx
    @left, @right = nil, nil
  end

end