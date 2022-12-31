/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-12-31
 */
class Solution {
    fun distanceBetweenBusStops(distance: IntArray, start: Int, destination: Int) =
        kotlin.math.min(distance.getDistance(start, destination), distance.getDistance(destination, start))

    private fun IntArray.getDistance(x: Int, y: Int) =
        generateSequence(x) { (it + 1) % this.size }
            .takeWhile { it != y }
            .map { it }
            .sumBy { this[it] }
}
