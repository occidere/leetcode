import java.util.*;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();

        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); ++j) {
            freq.merge(s.charAt(j), 1, Integer::sum);

            while (freq.keySet().size() > k) {
                char leftMost = s.charAt(i++);
                int cnt = freq.get(leftMost) - 1;
                if (cnt == 0) {
                    freq.remove(leftMost);
                } else {
                    freq.put(leftMost, cnt);
                }
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }
}
