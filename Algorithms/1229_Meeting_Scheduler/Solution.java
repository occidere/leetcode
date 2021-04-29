import java.util.*;

class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int m = slots1.length, n = slots2.length;
        for (int i = 0, j = 0; i < m && j < n;) {
            if (slots1[i][1] < slots2[j][0]) {
                ++i;
            } else if (slots2[j][1] < slots1[i][0]) {
                ++j;
            } else {
                int start = Math.max(slots1[i][0], slots2[j][0]), end = Math.min(slots1[i][1], slots2[j][1]);
                if (end - start >= duration) {
                    return Arrays.asList(start, start + duration);
                } else if (i < m - 1 && slots2[j][1] >= slots1[i + 1][0]) {
                    ++i;
                } else if (j < n - 1 && slots1[i][1] >= slots2[j + 1][0]) {
                    ++j;
                } else {
                    ++i;
                    ++j;
                }
            }
        }
        return Collections.emptyList();
    }
}
