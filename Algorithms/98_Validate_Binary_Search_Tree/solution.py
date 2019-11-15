# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from typing import *


class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        trace: List[int] = []
        self.in_order(root, trace)
        return trace == sorted(trace) and len(trace) == len(set(trace))

    def in_order(self, root: TreeNode, trace: List[int]) -> None:
        if root is None:
            return
        self.in_order(root.left, trace)
        trace.append(root.val)
        self.in_order(root.right, trace)
