class Solution {
    public boolean hasSameDigits(String s) {
        while (s.length() > 2) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < s.length(); ++i) {
                 sb.append(String.valueOf((s.charAt(i - 1) + s.charAt(i) - 48) % 10));
            }
            s = sb.toString();
        }
        return s.charAt(0) == s.charAt(1);
    }
}
