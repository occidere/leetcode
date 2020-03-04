class Solution:
    def freqAlphabets(self, s: str) -> str:
        s, ans = s[::-1], ''
        i, n = 0, len(s)
        while i < n:
            if s[i] == '#':
                ans += chr(int(s[i + 2] + s[i + 1]) + 96)
                i += 3
            else:
                ans += chr(int(s[i]) + 96)
                i += 1
        return ans[::-1]
