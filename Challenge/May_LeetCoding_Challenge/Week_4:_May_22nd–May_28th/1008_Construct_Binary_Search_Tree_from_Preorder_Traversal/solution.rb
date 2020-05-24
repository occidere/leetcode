# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {Integer[]} preorder
# @return {TreeNode}
def bst_from_preorder(preorder)
  root = TreeNode.new(preorder[0])
  preorder[1..-1].each { |p| add(root, p) }
  root
end

def add(root, p)
  if root.val > p
    root.left ? add(root.left, p) : root.left = TreeNode.new(p)
  else
    root.right ? add(root.right, p) : root.right = TreeNode.new(p)
  end
end