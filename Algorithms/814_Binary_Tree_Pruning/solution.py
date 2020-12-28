# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pruneTree(self, root: TreeNode) -> TreeNode:
        return root if self.prune(root) != 0 else None

    def prune(self, root: TreeNode) -> int:
        if not root:
            return 0
        else:
            left_sum = self.prune(root.left)
            right_sum = self.prune(root.right)

            if left_sum == 0:
                root.left = None
            if right_sum == 0:
                root.right = None

            return root.val + left_sum + right_sum
