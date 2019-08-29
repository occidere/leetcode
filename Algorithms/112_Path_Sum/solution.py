# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        if root:
            find = False

            def pre_order(t: TreeNode, acc: int) -> None:
                nonlocal find
                pre_order(t.left, acc + t.left.val) if t.left and not find else None
                pre_order(t.right, acc + t.right.val) if t.right and not find else None

                if not (t.left or t.right) or find:
                    if acc == sum:
                        find = True
                    return

            pre_order(root, root.val)
            return find
        else:
            return False
