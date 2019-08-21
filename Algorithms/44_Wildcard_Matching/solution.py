class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        cur_s = cur_p = 0
        last_s = last_p = -1

        while cur_s < len(s):
            if cur_p < len(p) and p[cur_p] in [s[cur_s], '?']:
                cur_s += 1
                cur_p += 1
            elif cur_p < len(p) and p[cur_p] == '*':
                last_s, last_p = cur_s + 1, cur_p
                cur_p += 1
            elif last_p != -1:
                cur_s, cur_p = last_s, last_p
            else:
                return False
        return p[cur_p:].count('*') == len(p) - cur_p
