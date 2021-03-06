from typing import *


class Solution:
    def minimumLengthEncoding(self, words: List[str]) -> int:
        remains = set(words)
        for w in words:
            for i in range(1, len(w)):
                remains.discard(w[i:])
        return sum(len(_) + 1 for _ in remains)
