import java.util.*;

class Solution {

    /*
    Approach:
         Deque (Mono Queue) 에 인덱스를 담는데, dq에 담긴 인덱스가 가리키는 값이 항상 내림차순이 되도록 유지
         ex) dq = [0, 1] 이고, 인덱스들이 가리키는 값은 [10, 5] 일 때, 현재 시도하려는 값이 idx = 2, val = 6 라면, dq = [0, 2] (vals = [10, 6]) 로 갱신됨
         또한, 현재 위치가 i일 때 dq 에 담긴 인덱스들 중 오래된 (=점프가 불가능한 이전 거리에 있는; < i - k) 인덱스는 먼저 제거
         ex) dq = [0, 1, 2] 이고 k = 2 이며 i = 3일 때 dq.peek() < i - k, 즉 0 < 1 (= 3 - 2) 인 dq 의 왼쪽 첫번째 값은 제거되서 dq = [1, 2] 가 됨
     
    Time Complexity: O(N)
    Space Complexity: O(N)

    참고: https://leetcode.com/problems/jump-game-vi/solution/
    */
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] score = new int[n];
        score[0] = nums[0];
        Deque<Integer> dq = new LinkedList<>();
        dq.offerLast(0);

        for (int i = 1; i < n; ++i) {
            while (dq.peekFirst() != null && dq.peekFirst() < i - k) {
                dq.pollFirst();
            }

            score[i] = score[dq.peek()] + nums[i];

            while (dq.peekLast() != null && score[i] >= score[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }

        return score[n - 1];
    }
}
