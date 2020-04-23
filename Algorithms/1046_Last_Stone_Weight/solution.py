from typing import *
import heapq


class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        pq = [-s for s in stones]
        heapq.heapify(pq)
        while len(pq) > 1:
            heapq.heappush(pq, -abs(heapq.heappop(pq) - heapq.heappop(pq)))
        return -pq[0] if pq else 0
