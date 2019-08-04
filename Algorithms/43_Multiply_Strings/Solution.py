class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        l1, l2 = len(num1), len(num2)
        pos = [0 for _ in range(0, l1 + l2)]

        for i in range(l1 - 1, -1, -1):
            for j in range(l2 - 1, -1, -1):
                p1, p2 = i + j, i + j + 1
                mul = int(num1[i]) * int(num2[j]) + pos[p2]

                pos[p1] += int(mul / 10)
                pos[p2] = mul % 10

        res = ''
        for p in pos:
            if not (len(res) == 0 and p == 0):
                res += str(p)
        return '0' if len(res) == 0 else res
