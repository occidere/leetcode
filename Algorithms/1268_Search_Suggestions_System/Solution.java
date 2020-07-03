import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Solution {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        final Map<Integer, Set<String>> suggests = Arrays.stream(products)
                .map(p -> new Object[]{p, calcCommonPrefix(searchWord, p)})
                .filter(p -> ((int) p[1]) != 0)
                .collect(Collectors.toMap(
                        p -> (int) p[1],
                        p -> new TreeSet<String>() {{ add((String) p[0]); }},
                        (a, b) -> { a.addAll(b); return a; },
                        TreeMap::new));

        final Integer[] freq = suggests.keySet().toArray(Integer[]::new);
        for (int i = freq.length - 1; i > 0; --i) {
            suggests.get(freq[i - 1]).addAll(suggests.get(freq[i]));
        }

        int commonPrefix = 0;
        final List<List<String>> ans = new ArrayList<>(searchWord.length());
        for (int curCommonPrefix : suggests.keySet()) {
            final List<String> subList = suggests.get(curCommonPrefix).stream().limit(3).collect(Collectors.toList());
            for (int i = 0; i < curCommonPrefix - commonPrefix; ++i) {
                ans.add(subList);
            }
            commonPrefix = curCommonPrefix;
        }

        final int insufficient = searchWord.length() - ans.size();
        for (int i = 0; i < insufficient; ++i) {
            ans.add(Collections.emptyList());
        }

        return ans;
    }

    private int calcCommonPrefix(String searchWord, String product) {
        int minLen = Math.min(searchWord.length(), product.length()), cnt = 0;
        for (int i = 0; i < minLen && searchWord.charAt(i) == product.charAt(i); ++i, ++cnt);
        return cnt;
    }
}