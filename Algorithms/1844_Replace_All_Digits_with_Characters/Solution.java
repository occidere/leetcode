class Solution {
    public String replaceDigits(String s) {
        char[] cs = s.toCharArray();
        for (int i = 1; i < cs.length; i += 2) {
            cs[i] += cs[i - 1] - 48;
        }
        return new String(cs);
    }
}
