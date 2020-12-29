from typing import *


class Solution:
    def reverseParentheses(self, s: str) -> str:
        stk: List[str] = []

        for c in s:
            stk.append(self.pops(stk) if c == ')' else c)

        return self.pops(stk)

    @staticmethod
    def pops(stk: List[str]) -> str:
        s: List[str] = []
        while stk:
            top = stk.pop()
            if top != '(':
                s.append(top)
            else:
                break
        return ''.join(s)[::-1]
