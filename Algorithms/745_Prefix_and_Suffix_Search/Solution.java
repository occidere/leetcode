import java.util.*;

class WordFilter {
    private Map<String, Map<Integer, String>> prefixTrie = new HashMap<>();
    private Map<String, Map<Integer, String>> suffixTrie = new HashMap<>();

    /*
    Approach: 모든 prefix, suffix 들에 대해 매칭되는 값과 그 때 인덱스를 음수로 저장함 (TreeMap 을 써서 역순 자동 정렬 적용).
    이후 검색하려는 prefix, suffix 에 매칭되는 결과가 둘다 있을 때 인덱스의 최대값을 리턴

    Time Complexity: O(M * N). M은 words 의 길이, N 은 단어의 길이
    Space Complexity: O(M * N)
    */
    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; ++i) {
            String w = words[i];
            for (int j = 0; j < w.length(); ++j) {
                String prefix = w.substring(0, j + 1);
                String suffix = w.substring(j);

                if (!prefixTrie.containsKey(prefix)) {
                    prefixTrie.put(prefix, new TreeMap<Integer, String>());
                }
                if (!suffixTrie.containsKey(suffix)) {
                    suffixTrie.put(suffix, new TreeMap<Integer, String>());
                }

                prefixTrie.get(prefix).put(-i, w);
                suffixTrie.get(suffix).put(-i, w);
            }
        }
    }

    public int f(String prefix, String suffix) {
        Map<Integer, String> prefixMatched = prefixTrie.getOrDefault(prefix, new TreeMap<>());
        Map<Integer, String> suffixMatched = suffixTrie.getOrDefault(suffix, new TreeMap<>());
        for (Map.Entry<Integer, String> e : prefixMatched.entrySet()) {
            if (suffixMatched.containsKey(e.getKey())) {
                return -e.getKey();
            }
        }
        return -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
