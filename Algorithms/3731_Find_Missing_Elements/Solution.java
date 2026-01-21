class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; ++i) {
            for (int k = nums[i - 1] + 1; k < nums[i]; ++k) {
                res.add(k);
            }
        }
        return res;
    }
}
