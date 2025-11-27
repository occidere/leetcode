public class Solution {
    private static int maxNum;
    private static String res = null;

    public String smallestNumber(String pattern) {
        res = null;
        maxNum = pattern.length() + 1;
        dfs(pattern, "");
        return res;
    }

    private void dfs(String pattern, String selected) {
        if (pattern.length() + 1 == selected.length()) {
            if (res == null && isValid(pattern, selected)) {
                res = selected;
            }
            return;
        }

        for (int i = 1; i <= maxNum; ++i) {
            if (res == null && !selected.contains(String.valueOf(i))) {
                dfs(pattern, selected + i);
            }
        }
    }

    private boolean isValid(String pattern, String selected) {
        for (int i = 0; i < pattern.length(); ++i) {
            char c = pattern.charAt(i);
            char a = selected.charAt(i);
            char b = selected.charAt(i + 1);
            if ((c == 'I' && a > b) || (c == 'D' && a < b)) {
                return false;
            }
        }
        return true;
    }
}
