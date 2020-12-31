from typing import *


class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        stk: List[int] = []
        i = 0
        for element in pushed:
            stk.append(element)
            while stk and stk[-1] == popped[i]:
                stk.pop()
                i += 1
        return not stk
