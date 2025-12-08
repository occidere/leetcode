import java.util.*;

public class Solution {
    public int maxFreqSum(String s) {
        Map<Character, Integer> vFreq = new HashMap<>();
        Map<Character, Integer> cFreq = new HashMap<>();
        for (var c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vFreq.put(c, 1 + vFreq.getOrDefault(c, 0));
            } else {
                cFreq.put(c, 1 + cFreq.getOrDefault(c, 0));
            }
        }
        return (int) vFreq.values().stream().mapToInt(x -> (int) x).max().orElse(0)
            + (int) cFreq.values().stream().mapToInt(x -> (int) x).max().orElse(0);
    }
}
