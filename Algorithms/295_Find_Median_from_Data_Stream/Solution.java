import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

    private final PriorityQueue<Integer> minHeap, maxHeap;

    public MedianFinder() {
        // 만약 {1, 2, 3, 4, 5} 라면
        minHeap = new PriorityQueue<>(); // 큰거 절반 (3, 4, 5)
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 작은거 절반 (1, 2)
    }

    // 아래 과정을 통해 항상 {minHeap 원소들의 값 > maxHeap 원소들의 값} 이 보장됨
    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());

        if (minHeap.size() < maxHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }

    @SuppressWarnings("ConstantConditions")
    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            // 큰 값 그룹 중 최소값 + 작은 값 그룹 중 최대값 / 2 = median
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
}