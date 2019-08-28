class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if not root:
            return True
        is_balanced = True

        def check(t: TreeNode, depth: int) -> int:
            nonlocal is_balanced
            if not t:
                return depth
            l_depth, r_depth = check(t.left, depth + 1), check(t.right, depth + 1)
            is_balanced = abs(l_depth - r_depth) <= 1 and is_balanced
            return max(l_depth, r_depth)

        return abs(check(root.left, 0) - check(root.right, 0)) <= 1 and is_balanced
