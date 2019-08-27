from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        o1, o2 = [], []
        self.pre_order(p, o1)
        self.pre_order(q, o2)
        return o1 == o2

    def pre_order(self, t: TreeNode, o: List) -> None:
        o.append(t.val if t else None)
        if not t:
            return
        self.pre_order(t.left, o)
        self.pre_order(t.right, o)
