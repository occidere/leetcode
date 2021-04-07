import java.util.*;

class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int acc = 0, n = s.length(), half = s.length() >> 1;
        for (int i = 0; i < half; ++i) {
            if (vowels.contains(s.charAt(i))) {
                ++acc;
            }
            if (vowels.contains(s.charAt(n - i - 1))) {
                --acc;
            }
        }
        return acc == 0;
    }
}
