import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        return Arrays.stream(words)
                .collect(Collectors.toMap(s -> s, o -> 1, Integer::sum))
                .entrySet().stream()
                .map(WordCount::new)
                .sorted((w1, w2) -> w1.count != w2.count ? w2.count - w1.count : w1.word.compareTo(w2.word))
                .limit(k)
                .map(wc -> wc.word)
                .collect(Collectors.toList());
    }

    private static class WordCount {
        String word;
        int count;

        public WordCount(Map.Entry<String, Integer> entry) {
            this.word = entry.getKey();
            this.count = entry.getValue();
        }
    }
}