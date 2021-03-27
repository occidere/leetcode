class Solution {
    public int countSubstrings(String s) {
        return dpSolution(s);
//        return expandFromCenter(s);
    }

    /*
    Approach: dp[i][j] = i ~ j 까지가 팰린드롬이면 true. 길이 1 짜리, 2 짜리 체크 후, 3 ~ n 짜리 체크 진행.
    ex) abba 일 때 양 끝이 같으면서 (a == a) 내부가 팰린드롬이면 (bb), 모두 팰린드롬 (abba)

    Time Complexity: O(N^2)
    Space Complexity: O(N^2)
    */
    private int dpSolution(String s) {
        int total = 0;
        if (s != null && s.length() > 0) {
            int n = s.length();
            boolean[][] dp = new boolean[n][n];

            for (int i = 0; i < n; ++i) {
                dp[i][i] = true;
                ++total;
            }

            for (int i = 1; i < n; ++i) {
                if (s.charAt(i - 1) == s.charAt(i)) {
                    dp[i - 1][i] = true;
                    ++total;
                }
            }

            for (int len = 3; len <= n; ++len) {
                for (int i = 0, j = i + len - 1; j < n; ++i, ++j) {
                    if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        ++total;
                    }
                }
            }
        }
        return total;
    }

    /*
    Approach: 각 인덱스들을 중심으로 삼아서 좌우로 팽창하며 팰린드롬 체크. 단 홀/짝수 팰린드롬을 고려해서 2개로 진행
    Time Complexity: O(N^2)
    Space Complexity: O(1)
    */
    private int expandFromCenter(String s) {
        int total = 0;
        if (s != null && s.length() > 0) {
            for (int i = 0; i < s.length(); ++i) {
                total += getPalindromeCount(s, i, i); // case of aba
                total += getPalindromeCount(s, i, i + 1); // case of abba
            }
        }
        return total;
    }

    private int getPalindromeCount(String s, int left, int right) {
        int count = 0;
        while (0 <= left && right < s.length() && s.charAt(left) == s.charAt(right)) {
            ++count;
            --left;
            ++right;
        }
        return count;
    }

    /*
    Approach: 모든 substring들에 대해 팰린드롬 체크
    Time Complexity: O(N^3). 모든 substring 시도에서 O(N^2), 팰린드롬 체크에서 O(N)
    Space Complexity: O(1)
    */
    private int naiveApproach(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); ++i) {
            int ans = 0;
            for (int j = i; j < s.length(); ++j) {
                if (isPalindrome(s, i, j)) {
                    ++ans;
                }
            }
            total += ans;
        }
        return total;
    }

    private boolean isPalindrome(String s, int from, int to) {
        while (from <= to) {
            if (s.charAt(from++) != s.charAt(to--)) {
                return false;
            }
        }
        return true;
    }
}
