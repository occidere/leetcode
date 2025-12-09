import java.util.*;

public class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        Set<Integer> fs = Arrays.stream(friends)
            .boxed()
            .collect(Collectors.toSet());
        int i = 0;
        int[] res = new int[friends.length];
        for (int k : order) {
            if (fs.contains(k)) {
                res[i++] = k;
            }
        }
        return res;
    }
}
