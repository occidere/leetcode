class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        return (int) (getMaxDist(horizontalCuts, h) * getMaxDist(verticalCuts, w) % 1000000007);
    }

    private long getMaxDist(int[] arr, int end) {
        Arrays.sort(arr);
        long maxDist = 0, prev = 0;
        for (int i = 0; i < arr.length; ++i) {
            maxDist = Math.max(maxDist, arr[i] - prev);
            prev = arr[i];
        }
        return Math.max(maxDist, end - prev);
    }
}
