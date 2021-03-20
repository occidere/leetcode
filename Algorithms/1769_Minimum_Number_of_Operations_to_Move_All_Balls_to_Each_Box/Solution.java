class Solution {
    public int[] minOperations(String boxes) {
        int leftSum = 0, rightSum = 0;
        int leftCount = 0, rightCount = 0;
        for (int i = 0; i < boxes.length(); ++i) {
            if (boxes.charAt(i) == '1') {
                rightSum += i;
                ++rightCount;
            }
        }

        int[] ans = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); ++i) {
            ans[i] = leftSum + rightSum;
            if (boxes.charAt(i) == '1') {
                ++leftCount;
                --rightCount;
            }
            leftSum += leftCount;
            rightSum -= rightCount;
        }

        return ans;
    }
}
