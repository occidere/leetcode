from collections import defaultdict
from typing import *

"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""


class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root:
            return []
        else:
            q: List[Tuple[int, Node]] = [(0, root)]

            i = 0
            while i < len(q):
                if q[i][1].children:
                    q.extend(map(lambda x: (q[i][0] + 1, x), q[i][1].children))
                i += 1

            d = defaultdict(list)
            for t in q:
                d[t[0]].append(t[1])

            return [list(map(lambda x: x.val, t)) for t in d.values()]
