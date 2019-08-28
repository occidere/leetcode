from typing import *


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        cache = {}
        self.pre_order(root, 1, cache)
        return list(map(lambda t: t[1], sorted(cache.items(), reverse=True)))

    def pre_order(self, t: TreeNode, depth: int, cache: Dict) -> None:
        if not t:
            return
        cache[depth] = cache.get(depth, []) + [t.val]
        self.pre_order(t.left, depth + 1, cache)
        self.pre_order(t.right, depth + 1, cache)
