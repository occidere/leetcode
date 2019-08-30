from typing import *


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices:
            return 0
        max_profit, min_price = 0, prices[0]
        for p in prices[1:]:
            max_profit, min_price = max(max_profit, p - min_price), min(min_price, p)
        return max_profit
