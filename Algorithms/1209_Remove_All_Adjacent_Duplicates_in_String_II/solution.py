from typing import List


class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        stk: List[(str, int)] = []
        for c in s:
            top, freq = ('', 0) if not stk else stk[-1]
            stk.append((c, 1 + (freq if c == top else 0)))
            while len(stk) >= k and stk[-1][1] == k:
                stk = stk[:-k]
        return ''.join([x for x, _ in stk])
