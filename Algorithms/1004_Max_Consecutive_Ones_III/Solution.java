class Solution {
    public int longestOnes(int[] A, int K) {
        int i = 0, j = 0;
        for (; j < A.length; ++j) {
            if (A[j] == 0) {
                --K;
            }
            if (K < 0) {
                if (A[i++] == 0) {
                    ++K;
                }
            }
        }
        return j - i;
    }
}
