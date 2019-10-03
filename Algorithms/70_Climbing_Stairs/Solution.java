class Solution {

    public int climbStairs(int n) {
        int a = 1, b = 1;
        for (int i = 0; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return a;
    }
}