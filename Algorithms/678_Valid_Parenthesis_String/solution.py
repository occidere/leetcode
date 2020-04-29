class Solution:
    def checkValidString(self, s: str) -> bool:
        # Minimum count of open parenthesis, Maximum count of open parenthesis individually
        cmin = cmax = 0

        for k in s:
            if k == '(':
                cmin += 1
                cmax += 1
            elif k == ')':
                cmax -= 1
                cmin = max(cmin - 1, 0)
            else:
                cmax += 1
                cmin = max(cmin - 1, 0)
            if cmax < 0:
                return False

        return cmin == 0
