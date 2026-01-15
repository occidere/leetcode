class Solution {
    public boolean isBalanced(String num) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < num.length(); ++i) {
            if (i % 2 == 0) {
                x += num.charAt(i) - 48;
            } else {
                y += num.charAt(i) - 48;
            }
        }
        return x == y;
    }
}
