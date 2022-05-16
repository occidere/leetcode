class Solution {

    /* Ref: https://leetcode.com/problems/minimum-number-of-frogs-croaking/discuss/586543/C%2B%2BJava-with-picture-simulation */
    fun minNumberOfFrogs(croakOfFrogs: String): Int {
        var (frogs, maxFrogs) = 0 to 0
        val charCnt = IntArray(5) { 0 } // croak 이 sequential 한지 체크에 사용
        for (ch in croakOfFrogs) {
            val idx = when (ch) {
                'c' -> 0
                'r' -> 1
                'o' -> 2
                'a' -> 3
                'k' -> 4
                else -> -1
            }
            ++charCnt[idx]
            if (idx == 0) {
                maxFrogs = kotlin.math.max(maxFrogs, ++frogs)
            } else if (--charCnt[idx - 1] < 0) {
                return -1
            } else if (idx == 4) {
                --frogs
            }
        }
        return if (frogs == 0) maxFrogs else -1
    }


    /* TLE */
//    private val croakChars = setOf('c', 'r', 'o', 'a', 'k')
//
//    fun minNumberOfFrogs(croakOfFrogs: String): Int {
//        val frogRanges = IntArray(croakOfFrogs.length) { 0 }
//        val croakCount = croakChars.associateWith { mutableListOf<Int>() }.toMutableMap()
//        for (i in croakOfFrogs.indices) {
//            croakCount[croakOfFrogs[i]]!!.add(i)
//            croakCount.getFrogRange()?.let { p -> (p.first..p.second).forEach { ++frogRanges[it] } }
//        }
//
//        return if (frogRanges.any { it == 0 }) -1 else frogRanges.max()!!
//    }
//
//    private fun MutableMap<Char, MutableList<Int>>.getFrogRange(): Pair<Int, Int>? {
//        val croak = croakChars.map { this[it]!! }
//        return if (croak.canMakeFrog()) {
//            croakChars.map { this[it]!!.removeAt(0) }
//                .sorted()
//                .let { it.first() to it.last() }
//        } else null
//    }
//
//    private fun List<List<Int>>.canMakeFrog() = zipWithNext()
//        .all { it.first.isNotEmpty() && it.second.isNotEmpty() && it.first.first() < it.second.first() }
}
