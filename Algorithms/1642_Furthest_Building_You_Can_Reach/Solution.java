import java.util.*;

class Solution {

    /*
    Approach: minHeap 을 이용해서 Ladder 사용을 최소화 하는 방향으로 진행

    Time Complexity: O(NlogN)
    Space Complexity: O(N)
    */
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // ladders
        int brickUsedCount = 0;

        for (int i = 1; i < heights.length; ++i) {
            int h = heights[i] < heights[i - 1] ? 0 : heights[i] - heights[i - 1];
            if (minHeap.size() < ladders) {
                minHeap.add(h);
            } else {
                if (!minHeap.isEmpty() && h > minHeap.peek()) {
                    if (minHeap.peek() <= bricks) {
                        bricks -= minHeap.poll();
                        ++brickUsedCount;
                        minHeap.add(h);
                    } else {
                        break;
                    }
                } else {
                    if (h <= bricks) {
                        bricks -= h;
                        ++brickUsedCount;
                    } else {
                        break;
                    }
                }
            }
        }

        return minHeap.size() + brickUsedCount;
    }
}
