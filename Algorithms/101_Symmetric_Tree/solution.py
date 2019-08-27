from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    def isSymmetric(self, root: TreeNode) -> bool:
        o1, o2 = [], []
        self.pre_order(root.left if root else None, o1)
        self.post_order(root.right if root else None, o2)
        return o1 == o2

    def pre_order(self, t: TreeNode, o: List) -> None:
        o.append(t.val if t else None)
        if not t:
            return
        self.pre_order(t.left, o)
        self.pre_order(t.right, o)

    def post_order(self, t: TreeNode, o: List) -> None:
        o.append(t.val if t else None)
        if not t:
            return
        self.post_order(t.right, o)
        self.post_order(t.left, o)
