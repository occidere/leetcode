# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
import re
from typing import *


class Solution:
    def recoverFromPreorder(self, S: str) -> TreeNode:
        depth_list = list(map(len, re.split(r'\d+', S)[:-1]))
        nodes = list(map(lambda t: TreeNode(t), re.split(r'\D+', S)))
        last: List[TreeNode] = [None for _ in range(len(depth_list))]

        for depth, node in zip(depth_list, nodes):
            if depth != 0:
                if last[depth - 1].left is None:
                    last[depth - 1].left = node
                else:
                    last[depth - 1].right = node
            last[depth] = node

        return nodes[0]
