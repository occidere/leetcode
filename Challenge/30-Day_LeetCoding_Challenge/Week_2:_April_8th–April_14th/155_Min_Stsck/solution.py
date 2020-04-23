class MinStack:

    def __init__(self):
        self.stack = []
        self.min_val = None

    def push(self, x: int) -> None:
        if self.min_val is None or x <= self.min_val:
            self.stack.append(self.min_val)
            self.min_val = x
        self.stack.append(x)

    def pop(self) -> None:
        if self.stack.pop() == self.min_val:
            self.min_val = self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_val
