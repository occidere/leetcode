class Solution {
    public int[] minCosts(int[] cost) {
        int[] res = new int[cost.length];
        res[0] = cost[0];
        int leftMin = cost[0];
        for (int i = 1; i < cost.length; ++i) {
            leftMin = res[i] = Math.min(leftMin, cost[i]);
        }
        return res;
    }
}
