class Solution {
    public int largestUniqueNumber(int[] A) {
        int[] cnt = new int[1001];
        for (int a : A) {
            ++cnt[a];
        }
        for (int i = cnt.length - 1; i >= 0; --i) {
            if (cnt[i] == 1) {
                return i;
            }
        }
        return -1;
    }
}
