import java.util.*;

/*
Approach: BinarySearch를 이용한 LIS 알고리즘을 응용. 중요 포인트는 width를 오름차순으로 정렬하고, 동일한 값이 있는 경우 height의 내림차순을 정렬하는 것.
'w 오름차순 -> h 내림차순'으로 정렬한 뒤, h 값들에 대해서 LIS를 계산하면 됨.
이렇게 하는 이유는 만약 w 값과 h 값이 모두 오름차순일 땐 w 값이 같은 경우에도 LIS를 만들기 때문
ex)
[3,4], [3,5], [7,8] 로 정렬하면 LIS 는 4->5->8 이 되는데 앞의 2개의 w 값이 3으로 같기 때문에 문제에서 요구하는 LIS를 찾을 수 없음
따라서 [3,5], [3,4], [7,8] 로 정렬해야만 4->8 로 항상 w 와 h 값이 큰 LIS를 만들 수 있음

Time Complexity: O(NlogN). BinarySearch에서 O(logN) * 모든 원소 탐색에서 O(N)
Space Complexity: O(N)
*/
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int lengthOfLIS = 0;
        int[] dp = new int[envelopes.length];
        for (int[] e : envelopes) {
            int i = Arrays.binarySearch(dp, 0, lengthOfLIS, e[1]);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = e[1];
            if (i == lengthOfLIS) {
                ++lengthOfLIS;
            }
        }
        return lengthOfLIS;
    }
}
