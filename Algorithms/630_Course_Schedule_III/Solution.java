import java.util.*;

class Solution {

    /*
    Approach: courses를 lastDay 빠른순 & duration 짧은 순으로 정렬함
    현재 사용한 시간 + 선택한 코스의 소요시간 <= 선택한 코스 데드라인 인 경우 선택.
    선택한 코스들은 우선순위 큐에 담아둠 (코스 소요시간 긴 순 & 데드라인 짧은 순)
    만약 현재 코스를 선택할 수 없는 경우, 이미 선택한 코스중 하나를 버리고 선택할 수 있는지 판단 (swap)
    - 이미 선택한 코스 중 소요시간이 제일 긴 놈을 버렸을 때 지금꺼를 선택할 수 있으면 swap 한다
    - 코스는 데드라인 짧은 순으로 정렬했기 때문에 이미 선택한 코스는 현재 시간보다 데드라인이 빠르므로 swap 해도 문제가 없다

    Time Complexity: O(NlogN)
    Space Complexity: O(N)
    */
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        int count = 0, curDay = 0;
        for (int[] course : courses) {
            if (curDay + course[0] <= course[1]) {
                curDay += course[0];
                ++count;
                pq.offer(course);
            } else if (!pq.isEmpty() && 
                       course[0] < pq.peek()[0] && 
                       curDay - pq.peek()[0] + course[0] <= course[1]) {
                curDay += course[0] - pq.poll()[0];
                pq.offer(course);
            }
        }
        
        return count;
    }
}
