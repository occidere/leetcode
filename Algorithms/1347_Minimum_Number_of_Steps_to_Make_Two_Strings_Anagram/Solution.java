import java.util.*;

class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> sFreq = new HashMap<>();
        for (char c : s.toCharArray()) {
            sFreq.merge(c, 1, Integer::sum);
        }
        for (char c : t.toCharArray()) {
            if (sFreq.getOrDefault(c, 0) > 0) {
                sFreq.merge(c, -1, Integer::sum);
            }
        }
        int sum = 0;
        for (int k : sFreq.values()) {
            sum += k;
        }
        return sum;
    }
}
