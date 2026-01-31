class Solution {
    public int minimumChairs(String s) {
        int res = 0;
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == 'E') {
                res = Math.max(res, ++cnt);
            } else {
                --cnt;
            }
        }
        return res;
    }
}
