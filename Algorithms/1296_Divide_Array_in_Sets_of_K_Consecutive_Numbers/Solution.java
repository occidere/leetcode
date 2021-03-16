import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Solution {

    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k == 0) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
            Arrays.stream(nums).boxed()
                    .collect(Collectors.groupingBy(x -> x))
                    .forEach((key, val) -> pq.add(new int[]{key, val.size()}));

            while (!pq.isEmpty()) {
                int[][] buf = new int[k][2];
                for (int i = 0; i < k; i++) {
                    buf[i] = pq.poll();
                }
                for (int i = 1; i < k; i++) {
                    if (buf[i] == null || buf[i - 1][0] != buf[i][0] - 1) {
                        return false;
                    }
                }
                for (int i = 0; i < k; i++) {
                    if (--buf[i][1] > 0) {
                        pq.add(buf[i]);
                    }
                }
            }

            return true;
        }
        return false;
    }
}