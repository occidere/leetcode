import java.util.*
import kotlin.math.max
import kotlin.math.min

class Solution {
    fun minimumDeviation(nums: IntArray): Int {
        // Shrink original num to 1 if even => minVal (shrank from origin num)
        // Create pair (minVal, originNum)
        val pq = PriorityQueue<Pair<Int, Int>> { p1, p2 -> p1.first - p2.first }.apply {
            addAll(nums.map { it / (it and -it) to it }) // i / (i & -i) => Get max odd from even by dividing 2
        }
        var maxVal = pq.maxBy { it.first }!!.first // Find maxVal from minVal (shrank from origin)
        var minDev = 0x3f3f3f3f

        // If size different, it means that no more update left.
        while (pq.size == nums.size) {
            val (minVal, origin) = pq.poll()
            minDev = min(minDev, maxVal - minVal)

            // We can increase minVal until to origin if needed.
            if (minVal % 2 == 1 || minVal < origin) {
                pq.add(minVal shl 1 to origin) // Increase minVal by * 2
                maxVal = max(maxVal, minVal shl 1) // Update maxVal
            }
        }

        return minDev
    }
}