import java.util.*;

/**
 * @author occidere
 * @blog: https://blog.naver.com/occidere
 * @github: https://github.com/occidere
 * @since 2025-12-07
 */
public class StreamChecker {

    private final TreeSet<Integer> suffixLens = new TreeSet<>();
    private final Map<Integer, Set<String>> wordsByLen = new HashMap<>();

    private final StringBuilder sb = new StringBuilder();
    private final Map<Integer, String> chunksByLen = new HashMap<>();

    public StreamChecker(String[] words) {
        for (var word : words) {
            int len = word.length();
            if (!wordsByLen.containsKey(len)) {
                wordsByLen.put(len, new HashSet<>());
            }
            wordsByLen.get(len).add(word);
            suffixLens.add(len);
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        int strLen = sb.length();

        // Add str if not exist before
        if (suffixLens.contains(strLen) && !chunksByLen.containsKey(strLen)) {
            chunksByLen.put(strLen, sb.toString());
        }

        boolean find = false;
        for (var suffixLen : suffixLens) {
            if (suffixLen > strLen) {
                break;
            }

            // Update str previously added before
            if (suffixLen != strLen && chunksByLen.containsKey(suffixLen)) {
                String suffix = (chunksByLen.get(suffixLen) + letter).substring(1);
                chunksByLen.put(suffixLen, suffix);
            }

            // Check
            find = find || wordsByLen.get(suffixLen).contains(chunksByLen.get(suffixLen));
        }

        return find;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
