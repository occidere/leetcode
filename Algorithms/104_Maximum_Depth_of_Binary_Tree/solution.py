from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    def __init__(self):
        self.max_depth = 0

    def maxDepth(self, root: TreeNode) -> int:
        self.pre_order(root, 1)
        return self.max_depth

    def pre_order(self, t: TreeNode, cur_depth: int) -> None:
        if not t:
            return
        self.max_depth = max(self.max_depth, cur_depth)
        self.pre_order(t.left, cur_depth + 1)
        self.pre_order(t.right, cur_depth + 1)
