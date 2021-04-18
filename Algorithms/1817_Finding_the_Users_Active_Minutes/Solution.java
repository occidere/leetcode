import java.util.*;

class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> uam = new HashMap<>();
        for (int[] log : logs) {
            if (!uam.containsKey(log[0])) {
                uam.put(log[0], new HashSet<>());
            }
            uam.get(log[0]).add(log[1]);
        }

        int[] ans = new int[k];
        for (Set<Integer> activities : uam.values()) {
            ++ans[activities.size() - 1];
        }
        return ans;
    }
}
