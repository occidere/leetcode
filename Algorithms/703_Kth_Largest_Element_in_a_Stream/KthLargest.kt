import java.util.*

/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2021-01-16
 */
class KthLargest(private val k: Int, nums: IntArray) {
    private val minHeap = PriorityQueue<Int>()
    private val maxHeap = PriorityQueue<Int> { a, b -> b - a }

    init {
        nums.forEach { add(it) }
    }

    fun add(`val`: Int): Int {
        when {
            minHeap.size < k -> minHeap.add(`val`)
            minHeap.peek() < `val` -> {
                maxHeap.add(minHeap.poll())
                minHeap.add(`val`)
            }
            else -> maxHeap.add(`val`)
        }
        return minHeap.peek()
    }
}