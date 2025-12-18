public class Solution {
    public String stringHash(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i = i + k) {
            sb.append((char) ((s.substring(i, i + k)
                    .chars()
                    .map(c -> c - 97)
                    .sum() % 26) + 97));
        }
        return sb.toString();
    }
}