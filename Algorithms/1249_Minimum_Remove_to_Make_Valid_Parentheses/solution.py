from typing import *


class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        cs: List[str] = [c for c in s]
        stk: List[int] = []

        for i in range(0, len(cs)):
            if cs[i] == '(':
                stk.append(i)
            elif cs[i] == ')':
                if stk:
                    stk.pop()
                else:
                    cs[i] = ''

        for i in range(0, len(stk)):
            cs[stk[i]] = ''

        return ''.join(cs)
