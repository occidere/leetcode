from collections import defaultdict


class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        buf = defaultdict(lambda: 0)

        for s in magazine:
            buf[s] += 1

        for s in ransomNote:
            if buf[s] < 1:
                return False
            else:
                buf[s] -= 1

        return True;
