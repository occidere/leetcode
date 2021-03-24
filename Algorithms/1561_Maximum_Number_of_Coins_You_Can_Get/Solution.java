class Solution {
    public int maxCoins(int[] piles) {
        int ans = 0;
        java.util.Arrays.sort(piles);
        for (int i = piles.length / 3; i < piles.length; i += 2) {
            ans += piles[i];
        }
        return ans;
    }
}
