import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        final List<Point>[] cityCostInfo = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            cityCostInfo[i] = new ArrayList<>();
        }
        for (int[] f : flights) {
            cityCostInfo[f[0]].add(new Point(f[1], f[2]));
        }

        // {현재까지 비용, 현재 도시, 거쳐간 도시}, 비용 기준 오름차순 정렬 유지 (최단거리 베이스)
        final PriorityQueue<Flight> pq = new PriorityQueue<>(Comparator.comparingInt(f -> f.costUpToCurrentCity));
        pq.offer(new Flight(0, src, K + 1));

        while (!pq.isEmpty()) {
            final Flight f = pq.poll(); // 언제나 최소 비용인 도시부터 방문

            /* 언제나 더 방문할 수 있는 경우만 진행하고, 최소 비용 도시부터 가기 때문에 첫번째로 도착한 경로가 최단경로임이 보장됨 */
            if (f.currentCity == dst) {
                return f.costUpToCurrentCity;
            } else if (f.remainStopCount > 0) { // 더 방문할 수 있으면 진행
                for (Point next : cityCostInfo[f.currentCity]) {
                    pq.offer(new Flight(f.costUpToCurrentCity + next.y, next.x, f.remainStopCount - 1));
                }
            }
        }

        return -1;
    }

    private static class Flight {

        int costUpToCurrentCity;
        int currentCity;
        int remainStopCount;

        public Flight(int priceUntilCurrentCity, int currentCity, int remainStopCount) {
            this.costUpToCurrentCity = priceUntilCurrentCity;
            this.currentCity = currentCity;
            this.remainStopCount = remainStopCount;
        }
    }
}