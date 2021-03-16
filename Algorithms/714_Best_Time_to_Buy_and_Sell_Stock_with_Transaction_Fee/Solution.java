class Solution {
    public int maxProfit(int[] prices, int fee) {
        // cash: 주식은 없고 현금만 있는 경우의 최대 잠재 이익 상태
        // hold: 주식과 현금 둘다 있는 경우의 최대 잠재 이익 상태
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; ++i) {
            // 아래 2가지 경우 중 하나가 최대 잠재 이익 상태가 됨
            //   1. 주식 안산 상태 유지 = cash[i-1]
            //   2. 어제 산걸 오늘 팔아서 현금화= hold[i-1] + prices[i] - fee
            // => 둘 중 최대값(= 최대 잠재 이익)을 선택
            cash = Math.max(cash, hold + prices[i] - fee);
            // 아래 3가지 경우 중 하나가 최대 잠재 이익 상태가 됨
            //   1. 어제 산 주식 존버 = hold[i-1]
            //   2. 어젠 없었는데 오늘 새로 삼 = cash[i-1] - prices[i]
            //   3. 어제 산 주식을 오늘 팔고, 오늘 새로 또 삼 = hold[i-1] + prices[i] - fee + prices[i]
            // => 셋 중 최대값(= 최대 잠재 이익)을 선택
            // 이 때, 2번과 3번을 정리해보면 = cash[i-1] - prices[i] VS hold[i-1] + prices[i] - fee - prices[i] 이고,
            // 둘을 = (cash[i-1] VS hold[i-1] + prices[i] - fee) - prices[i] 로 묶을 수 있고,
            // (cash[i-1] VS hold[i-1] + prices[i] - fee) 는 위에서 구한 cash 구하는 식과 같기 때문에,
            // => cash - prices[i] 로 최종적으로 나타낼 수 있음
            hold = Math.max(hold, cash - prices[i]);
        }

        // 최종적으로 마지막엔 주식을 안 들고 있는것이 이익이기 때문에 주식 없고 현금만 보유한 경우의 최대 이익인 cash 를 반환
        return cash;
    }
}