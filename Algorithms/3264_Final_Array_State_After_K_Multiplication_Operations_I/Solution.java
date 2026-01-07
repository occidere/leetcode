class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        var pq = new PriorityQueue<int[]>((xs, ys) -> xs[1] == ys[1] ? xs[0] - ys[0] : xs[1] - ys[1]);

        for (int i = 0; i < nums.length; ++i) {
            pq.add(new int[]{i, nums[i]});
        }

        for (int i = 0; i < k; ++i) {
            var xs = pq.poll();
            xs[1] *= multiplier;
            pq.add(xs);
        }

        int[] res = new int[nums.length];
        while (!pq.isEmpty()) {
            var xs = pq.poll();
            res[xs[0]] = xs[1];
        }

        return res;
        
    }
}
