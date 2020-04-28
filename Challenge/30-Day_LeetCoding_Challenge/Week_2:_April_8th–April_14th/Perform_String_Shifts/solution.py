from typing import *


class Solution:
    def stringShift(self, s: str, shift: List[List[int]]) -> str:
        pos, s_len = 0, len(s)
        for direction, count in shift:
            pos += -count if direction else count
            pos += s_len if pos < 0 else 0
            pos %= s_len
        return s[pos:s_len] + s[0:pos]
