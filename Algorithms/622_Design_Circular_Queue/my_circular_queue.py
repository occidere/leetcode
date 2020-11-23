class MyCircularQueue:
    """
    @author occidere
    @Blog: https://occidere.blog.me
    @Github: https://github.com/occidere
    @since 2020-11-23
    """

    def __init__(self, k: int):
        self.q = [0 for _ in range(k)]
        self.front = 0
        self.rear = 0
        self.size = 0

    def enQueue(self, value: int) -> bool:
        if self.isFull():
            return False
        self.q[self.rear] = value
        self.rear = self.__incr(self.rear)
        self.size += 1
        return True

    def deQueue(self) -> bool:
        if self.isEmpty():
            return False
        self.front = self.__incr(self.front)
        self.size -= 1
        return True

    def Front(self) -> int:
        return -1 if self.isEmpty() else self.q[self.front]

    def Rear(self) -> int:
        return -1 if self.isEmpty() else self.q[self.__decr(self.rear)]

    def isEmpty(self) -> bool:
        return self.size == 0

    def isFull(self) -> bool:
        return self.size == len(self.q)

    def __incr(self, num: int) -> int:
        return (num + 1) % len(self.q)

    def __decr(self, num: int) -> int:
        return (num + len(self.q) - 1) % len(self.q)
