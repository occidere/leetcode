import java.util.*;

class Solution {
    public String sortSentence(String s) {
        return Arrays.stream(s.split(" "))
            .map(x -> new Object[]{x.charAt(x.length() - 1) - '0', x.substring(0, x.length() - 1)})
            .sorted((a, b) -> Integer.compare((int) a[0], (int) b[0]))
            .map(x -> (String) x[1])
            .collect(Collectors.joining(" "));
    }
}
