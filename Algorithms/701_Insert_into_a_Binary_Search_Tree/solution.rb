# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {TreeNode} root
# @param {Integer} val
# @return {TreeNode}
def insert_into_bst(root, val)
  if not root
    nil
  elsif val < root.val
    root.left ? insert_into_bst(root.left, val) : root.left = TreeNode.new(val)
  else
    root.right ? insert_into_bst(root.right, val) : root.right = TreeNode.new(val)
  end
  root
end