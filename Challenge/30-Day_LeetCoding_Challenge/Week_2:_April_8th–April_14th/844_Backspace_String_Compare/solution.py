class Solution:
    def backspaceCompare(self, S: str, T: str) -> bool:
        return self.parse(S) == self.parse(T)

    @staticmethod
    def parse(s: str) -> str:
        k = 0
        res: str = ''
        for i in range(len(s)):
            if s[i] == '#':
                k = max(0, k - 1)
                res = res[:k]
            else:
                k += 1
                res += s[i]
        return res[:k]


if __name__ == '__main__':
    sol = Solution()
    sol.backspaceCompare("a##c", "#a#c")
