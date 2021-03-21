import java.util.*;

class Solution {
    public boolean reorderedPowerOf2(int N) {
        int[] a1 = new int[10], a2 = new int[10];
        count(a1, N);
        for (int i = 0; i < 31; ++i) {
            count(a2, (1 << i));
            if (Arrays.equals(a1, a2)) {
                return true;
            }
        }
        return false;
    }

    private void count(int[] counter, int N) {
        Arrays.fill(counter, 0);
        for (char c : ("" + N).toCharArray()) {
            ++counter[c - '0'];
        }
    }
}
