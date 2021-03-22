import java.util.*;

class Solution {
    private static final Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> origins = new HashSet<>();
        Map<String, String> lowers = new HashMap<>();
        Map<String, String> lowerVowelless = new HashMap<>();

        for (String w : wordlist) {
            origins.add(w);
            String lower = w.toLowerCase();
            lowers.putIfAbsent(lower, w);
            lowerVowelless.putIfAbsent(toVowellessString(lower), w);
        }

        for (int i = 0; i < queries.length; ++i) {
            String s = queries[i], lower = s.toLowerCase();
            queries[i] = origins.contains(s) ? s :
                lowers.getOrDefault(lower,
                    lowerVowelless.getOrDefault(toVowellessString(lower), ""));
        }

        return queries;
    }

    private String toVowellessString(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0; i < s.length(); ++i) {
            if (VOWELS.contains(cs[i])) {
                cs[i] = '_';
            }
        }
        return new String(cs);
    }
}
