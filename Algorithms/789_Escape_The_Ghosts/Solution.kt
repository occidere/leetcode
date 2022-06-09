class Solution {
    fun escapeGhosts(ghosts: Array<IntArray>, target: IntArray) =
        intArrayOf(0, 0).getDist(target)
            .let { mine -> ghosts.all { mine < it.getDist(target) } }

    private fun IntArray.getDist(target: IntArray) =
        kotlin.math.abs(first() - target.first()) + kotlin.math.abs(last() - target.last())
}
