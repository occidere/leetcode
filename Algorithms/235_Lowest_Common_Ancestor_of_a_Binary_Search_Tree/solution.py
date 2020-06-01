# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from typing import *


class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        a1: List[TreeNode] = []
        a2: List[TreeNode] = []

        self.get_ancestors(root, p.val, a1)
        self.get_ancestors(root, q.val, a2)

        min_len = min(len(a1), len(a2))
        lca: [TreeNode, None] = None
        for i in range(0, min_len):
            if a1[i] == a2[i]:
                lca = a1[i]
            else:
                break

        return lca

    def get_ancestors(self, root: TreeNode, target: int, ancestors: List[TreeNode]) -> None:
        if root:
            ancestors.append(root)
            if target < root.val:
                self.get_ancestors(root.left, target, ancestors)
            elif target > root.val:
                self.get_ancestors(root.right, target, ancestors)
