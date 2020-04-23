# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.diameter = 0

    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        if root is not None:
            self.dfs(root)
        return self.diameter

    def dfs(self, node: TreeNode) -> int:
        left_max_depth = 0 if node.left is None else self.dfs(node.left)
        right_max_depth = 0 if node.right is None else self.dfs(node.right)
        total_max_depth = max(left_max_depth, right_max_depth)
        self.diameter = max(self.diameter, left_max_depth + right_max_depth)
        return total_max_depth + 1
