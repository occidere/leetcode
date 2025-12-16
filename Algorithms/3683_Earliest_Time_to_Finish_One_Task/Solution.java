public class Solution {
    public int earliestTime(int[][] tasks) {
        return Arrays.stream(tasks)
            .map(xs -> xs[0] + xs[1])
            .min(Integer::compare)
            .orElse(0);
    }
}
