import java.util.*;

class Solution {

    /*
    Approach: 앞에서부터 i개 + 뒤에서부터 k-i개 선택한 것 중 최대값 계산. 앞에서부터의 누적합과 뒤에서부터의 누적합을 각각 메모

    Time Complexity: O(N)
    Space Complexity: O(N)
    */
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] left = new int[n + 1], right = new int[n + 1];
        for (int i = 1; i <= k; ++i) {
            left[i] += left[i - 1] + cardPoints[i - 1];
            right[i] += right[i - 1] + cardPoints[n - i];
        }

        int maxPoints = 0;
        for (int i = 0; i <= k; ++i) {
            maxPoints = Math.max(maxPoints, left[i] + right[k - i]);
        }
        return maxPoints;
    }
}
