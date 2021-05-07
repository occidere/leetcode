class Solution {

    /*
    Approach: LCS 를 응용. 두 문자열의 Longest Common Subsequence 를 구한 뒤, 각각 문자열의 길이에서 뺀 값을 더하면 됨

    Time Complexity: O(M*N)
    Space Complexity: O(M*N)
    */
    public int minDistance(String word1, String word2) {
        word1 = "_" + word1;
        word2 = "_" + word2;
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return (m - 1 - dp[m - 1][n - 1]) + (n - 1 - dp[m - 1][n - 1]);
    }
}
