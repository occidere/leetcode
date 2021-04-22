import java.util.*;

class Solution {

    /*
    Approach: 각 rows 의 끝점의 등장 횟수를 map 에 기록. 가장 많이 등장한 끝점 = 수직선을 그었을 때 최소로 영향받는 위치

    Time Complexity: O(M*N)
    Space Complexity: O(M*N)
    */
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> endpoints = new HashMap<>();
        int acc = 0;

        for (List<Integer> rows : wall) {
            acc = 0;
            for (int r : rows) {
                acc += r;
                endpoints.merge(acc, 1, Integer::sum);
            }
        }
        endpoints.remove(acc);

        int minVal = wall.size();
        for (int w : endpoints.values()) {
            minVal = Math.min(minVal, wall.size() - w);
        }
        return minVal;
    }
}
