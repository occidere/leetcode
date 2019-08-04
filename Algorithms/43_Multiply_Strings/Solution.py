# TODO: Fix add, subtract functions efficiently
class Karatsuba:
    THRESHOLD = 80

    @staticmethod
    def multiply(x: str, y: str) -> str:
        if len(x) < Karatsuba.THRESHOLD or len(y) < Karatsuba.THRESHOLD:
            return str(int(x) * int(y))
        else:
            return Karatsuba.multiply_karatsuba(x, y)

    @staticmethod
    def multiply_karatsuba(x: str, y: str) -> str:
        x_len, y_len = len(x), len(y)
        if x_len != y_len:
            max_len = max(x_len, y_len)
            if max_len % 2:
                max_len += 1
            x = ''.join('0' for _ in range(0, max_len - x_len)) + x
            y = ''.join('0' for _ in range(0, max_len - y_len)) + y
            x_len = y_len = max_len

        half = int((x_len + 1) / 2)
        x1, x0 = x[0:half], x[half::]
        y1, y0 = y[0:half], y[half::]

        l = Karatsuba.multiply(x1, y1)
        n = Karatsuba.multiply(x0, y0)
        m = Karatsuba.multiply(str(int(x1) + int(x0)), str(int(y1) + int(y0)))
        m = str(int(m) - int(l) - int(n))

        suffix = ''.join('0' for _ in range(0, half))
        return str(int(l + suffix + suffix) + int(m + suffix) + int(n))


class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        return Karatsuba.multiply(num1, num2)
