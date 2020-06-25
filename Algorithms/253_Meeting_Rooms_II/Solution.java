import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int[] interval : intervals) {
            pq.offer(interval);
        }

        List<List<int[]>> reserved = new ArrayList<>() {{
            add(new ArrayList<>() {{
                add(pq.poll());
            }});
        }};

        loop: while (!pq.isEmpty()) {
            reserved.sort(Comparator.comparing(a -> a.get(a.size() - 1)[1]));
            int[] itv = pq.poll();
            for (List<int[]> itvs : reserved) {
                if (itvs.get(itvs.size() - 1)[1] <= itv[0]) {
                    itvs.add(itv);
                    continue loop;
                }
            }
            reserved.add(new ArrayList<>() {{
                add(itv);
            }});
        }

        return reserved.size();
    }
}