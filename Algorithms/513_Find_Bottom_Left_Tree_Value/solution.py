from typing import *


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
        leftmost_by_level: Dict[int, int] = {}
        max_level = 0

        def find_leftmost(node: TreeNode, level: int):
            nonlocal leftmost_by_level, max_level
            if node:
                max_level = max(max_level, level)
                if level not in leftmost_by_level:
                    leftmost_by_level[level] = node.val
                find_leftmost(node.left, level + 1)
                find_leftmost(node.right, level + 1)

        find_leftmost(root, 0)
        return leftmost_by_level[max_level]

