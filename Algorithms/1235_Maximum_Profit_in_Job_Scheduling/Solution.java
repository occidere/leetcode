import java.util.*;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[] dp = new int[profit.length];
        int[][] schedules = new int[profit.length][3];
        for (int i = 0; i < profit.length; ++i) {
            schedules[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(schedules, (a, b) -> a[0] - b[0]);
        return dfs(0, schedules, dp);
    }

    /*
    Approach: schedules 를 시작시간의 오름차순으로 정렬하고 Top-Down 방식의 DP 적용
    각 스케줄마다 선택(includeProfit) vs 선택 안하고 다음으로 넘어감(excludeProfit) 을 진행해서 최대값 선택

    Time Complexity: O(NlogN). dfs를 이용해 모든 스케줄 탐색 O(N) * 다음 탐색 대상 조회에 O(logN)
    Space Complexity: O(N). DP 배열 생성
    */
    private int dfs(int idx, int[][] schedules, int[] dp) {
        if (idx == dp.length) {
            return 0;
        } else if (dp[idx] != 0) {
            return dp[idx];
        }

        int includeProfit = schedules[idx][2] + dfs(getNextBinarySearch(idx, schedules), schedules, dp);
        int excludeProfit = dfs(idx + 1, schedules, dp);

        return dp[idx] = Math.max(includeProfit, excludeProfit);
    }

    /*
    Approach: 겹치지 않는 다음 스케줄 선택
    Time Complexity: O(N)
    Space Complexity: O(1)
    */
    private int getNext(int idx, int[][] schedules) {
        for (int i = idx + 1; i < schedules.length; ++i) {
            if (schedules[idx][1] <= schedules[i][0]) {
                return i;
            }
        }
        return schedules.length;
    }

    /*
    Approach: LowerBound를 이용해 찾으려는 수 보다 크거나 같은 첫번째 위치를 찾음.
    즉, 현재 스케줄이 5에 종료되었으면, 다음 스케줄 중 시작시간이 5보다 크거나 같은 첫번째 위치 반환.
    만약 찾지 못하면 초기 right 값 (schedules.length) 가 반환되며, dfs 함수에서 return 0 으로 이어짐

    Time Complexity: O(logN)
    Space Complexity: O(1)
    */
    private int getNextBinarySearch(int idx, int[][] schedules) {
        int target = schedules[idx][1]; // end time
        int left = idx + 1, right = schedules.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (schedules[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
