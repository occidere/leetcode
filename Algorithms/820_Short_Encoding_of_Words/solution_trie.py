from typing import *


class Solution:
    def minimumLengthEncoding(self, words: List[str]) -> int:
        root, leaves = {}, []
        for w in set(words):
            cur_node = root
            for ch in w[::-1]:
                next_node = cur_node.get(ch, {})
                cur_node[ch] = next_node
                cur_node = next_node
            leaves.append((cur_node, len(w)))

        return sum(level + 1 for nodes, level in leaves if len(nodes) == 0)
