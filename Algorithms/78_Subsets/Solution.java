import java.util.ArrayList;
import java.util.List;

class Solution {
    private int len;
    private int[] nums;
    private List<List<Integer>> subset = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        len = nums.length;
        dfs(-1, new ArrayList<>());
        return subset;
    }

    private void dfs(int cur, List<Integer> selected) {
        subset.add(new ArrayList<>(selected));
        if(selected.size() == len) {
            return;
        }
        for (int i = cur + 1; i < len; i++) {
            selected.add(nums[i]);
            dfs(i, selected);
            selected.remove(selected.size() - 1);
        }
    }
}