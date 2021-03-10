from typing import *


class Solution:
    idx = 0

    def expTree(self, s: str) -> 'Node':
        cur, self.idx = Node(s[self.idx]), self.idx + 1
        dq = [self.expTree(s) if cur.val == '(' else cur]

        while self.idx < len(s):
            cur, self.idx = Node(s[self.idx]), self.idx + 1
            if '0' <= cur.val <= '9':
                dq.append(self.mk_tree(dq, cur) if dq[-1].val in ['*', '/'] else cur)
            elif cur.val == '(':
                dq.append(self.mk_tree(dq, self.expTree(s)) if dq[-1].val in ['*', '/'] else self.expTree(s))
            elif cur.val == ')':
                break
            else:
                dq.append(cur)  # +, -

        while len(dq) > 1:
            left, root = dq.pop(0), dq.pop(0)
            root.left, root.right = left, dq.pop(0)
            dq.insert(0, root)
        return dq.pop(0)

    @staticmethod
    def mk_tree(dq: List['Node'], right: 'Node') -> 'Node':
        root = dq.pop()
        root.left, root.right = dq.pop(), right
        return root
