import java.util.*;

class Solution {

    /*
    참고: https://leetcode.com/problems/super-palindromes/discuss/174835/tell-you-how-to-get-all-super-palindrome(detailed-explanation)
    Approach: 10^9보다 작은 모든 팰린드롬을 구하고 (인풋이 10^18 미만이기 때문), 그 수들 중 제곱수가 팰린드롬인 놈들의 개수 리턴

    Time Complexity: O(W^1/4 * logW). W = 10^18
    Space Complexity: O(logW)
    */
    public int superpalindromesInRange(String left, String right) {
        List<Long> palindromes = new ArrayList<>();
        // 1자리수 팰린드롬 후보 생성
        for (long i = 1; i <= 9; ++i) {
            palindromes.add(i);
        }

        // 2자리수 이상 팰린드롬 후보 생성
        // 최대 4자리까지만 앞뒤로 붙이면 됨
        for (long i = 1; i < 10_000; ++i) {
            String l = i + "", r = new StringBuilder(l).reverse().toString();
            palindromes.add(Long.parseLong(l + r)); // ex) 12 21
            for (long mid = 0; mid < 10; ++mid) {
                palindromes.add(Long.parseLong(l + mid + r)); // ex) 12 1 21
            }
        }

        long low = Long.parseLong(left), high = Long.parseLong(right);
        int res = 0;
        for (long p : palindromes) {
            long square = p * p;
            if (isPalindrome(square + "")) {
                if (low <= square && square <= high) {
                    ++res;
                }
            }
        }

        return res;
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
