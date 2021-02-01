import kotlin.math.abs
import kotlin.math.max

class Solution {
    fun minDistance(height: Int, width: Int, tree: IntArray, squirrel: IntArray, nuts: Array<IntArray>): Int {
        var maxDist = -0x3f3f3f3f
        return nuts.map { nut ->
            nut.getDist(tree).run {
                // tree 와 nut 사이 거리 > squirrel 와 nut 사이 거리 가 되어야만, 다람쥐의 첫번째 nut 로 정했을 때 최단거리가 될 수 있음
                maxDist = max(maxDist, this - nut.getDist(squirrel))
                this shl 1 // tree <-> nut 왕복이므로 *2
            }
        }.sum() - maxDist
    }

    private fun IntArray.getDist(next: IntArray) = abs(this[0] - next[0]) + abs(this[1] - next[1])
}