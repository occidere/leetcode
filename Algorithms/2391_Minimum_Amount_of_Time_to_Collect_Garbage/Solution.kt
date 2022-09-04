/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-09-04
 */
class Solution {
    fun garbageCollection(garbage: Array<String>, travel: IntArray) = "MPG".sumBy { c ->
        var (times, move) = 0 to 0
        for (i in garbage.indices) {
            val targets = garbage[i].count { it == c }
            if (0 < targets) {
                times += targets
                times += move
                move = 0
            }

            if (i < travel.size) {
                move += travel[i]
            }
        }
        times
    }
}
