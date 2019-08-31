from typing import *


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        for i in range(1, len(prices)):
            max_profit += prices[i] - prices[i - 1] if prices[i] > prices[i - 1] else 0
        return max_profit
