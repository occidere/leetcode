class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] d = new int[n][3];
        d[0][0] = costs[0][0];
        d[0][1] = costs[0][1];
        d[0][2] = costs[0][2];
        for (int i = 1; i < n; ++i) {
            d[i][0] = costs[i][0] + Math.min(d[i - 1][1], d[i - 1][2]);
            d[i][1] = costs[i][1] + Math.min(d[i - 1][0], d[i - 1][2]);
            d[i][2] = costs[i][2] + Math.min(d[i - 1][0], d[i - 1][1]);
        }
        return Math.min(d[n - 1][0], Math.min(d[n - 1][1], d[n - 1][2]));
    }
}
