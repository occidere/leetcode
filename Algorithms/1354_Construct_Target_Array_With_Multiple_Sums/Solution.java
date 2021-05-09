import java.util.*;

class Solution {

    /*
    참고: https://leetcode.com/problems/construct-target-array-with-multiple-sums/solution/
    Approach: target 을 전부 1로 만드는 식으로 역순 진행. target 중 가장 큰 수 - 나머지 합을 구하며 1로 전부 만들 수 있는지 체크

    Time Complexity: O(N + logK * logN). N 은 target의 길이, K 는 target 중 최대값
    Space Complexity: O(N)
    */
    public boolean isPossible(int[] target) {
        if (target.length == 1) {
            return target[0] == 1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int t : target) {
            pq.offer(t);
            sum += t;
        }

        while (pq.element() > 1) {
            int largest = pq.poll();
            int rest = sum - largest;
            if (rest == 1) {
                return true; // n = 2 인 경우에만 발생
            }

            int x = largest % rest;
            if (x == 0 || x == largest) {
                return false; // x 가 0 (invalid) 거나 변하지 않았으면 더 이상 불가능
            }
            pq.offer(x);
            sum -= largest - x;
        }
        return true;
    }
}
