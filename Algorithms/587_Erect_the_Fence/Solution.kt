import java.util.*

class Solution {
    fun outerTrees(trees: Array<IntArray>) = if (trees.size < 4) trees else trees.monotoneChain()

    private fun Array<IntArray>.monotoneChain(): Array<IntArray> {
        // x 작은순 -> y 작은순
        val points = this.sortedWith(Comparator { a, b -> if (a[0] == b[0]) a[1] - b[1] else a[0] - b[0] })
            .toTypedArray()
        val convexHull = Stack<IntArray>()

        // Build lower layer
        for (i in points.indices) {
            while (convexHull.size >= 2 && isCW(convexHull[convexHull.size - 2], convexHull.peek(), points[i])) {
                convexHull.pop() // 우회전이 아니면 a, b, c 중 가운데 b 제거
            }
            convexHull.push(points[i])
        }
        convexHull.pop()

        // Build upper layer
        for (i in points.indices.reversed()) {
            while (convexHull.size >= 2 && isCW(convexHull[convexHull.size - 2], convexHull.peek(), points[i])) {
                convexHull.pop() // 우회전이 아니면 a, b, c 중 가운데 b 제거
            }
            convexHull.push(points[i])
        }

        return convexHull.distinct().toTypedArray()
    }

    private fun isCW(a: IntArray, b: IntArray, c: IntArray): Boolean =
        (b[1] - a[1]) * (c[0] - b[0]) - (b[0] - a[0]) * (c[1] - b[1]) > 0
}
