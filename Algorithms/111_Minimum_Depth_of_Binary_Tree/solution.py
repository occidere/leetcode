# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if root:
            min_depth = 0x3f3f3f3f

            def pre_order(t: TreeNode, depth: int) -> None:
                nonlocal min_depth
                pre_order(t.left, depth + 1) if t.left else None
                pre_order(t.right, depth + 1) if t.right else None
                min_depth = min_depth if t.left or t.right else min(min_depth, depth)
                return

            pre_order(root, 1)
            return min_depth
        else:
            return 0
