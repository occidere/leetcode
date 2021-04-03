import java.util.*;

class Solution {

    /*
    Approach: 대표적인 Knapsack 문제. dp[i][j] = 0을 i개, 1을 j개 선택할 때 만들 수 있는 최대 길이
    dp[i][j] = MAX(이전 단계에서 선택, 선택하지 않고 현재 유지)
    dp[i][j] = MAX(dp[i - cur 0's cnt][j - cur 1's cnt] + 1, dp[i][j])

    Time Complexity: O(M * N * L), L은 문자열의 최대 길이
    Space Complexity: O(M * N)
    */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int[] freq = getFreq(s);
            for (int zeroes = m; zeroes >= freq[0]; --zeroes) {
                for (int ones = n; ones >= freq[1]; --ones) {
                    // MAX(선택 하는 것, 선택 안하는 것)
                    dp[zeroes][ones] = Math.max(dp[zeroes - freq[0]][ones - freq[1]] + 1, dp[zeroes][ones]);
                }
            }
        }
        return dp[m][n];
    }
    
    private int[] getFreq(String s) {
        int[] freq = new int[2];
        for (char c : s.toCharArray()) {
            ++freq[c - '0'];
        }
        return freq;
    }
}
