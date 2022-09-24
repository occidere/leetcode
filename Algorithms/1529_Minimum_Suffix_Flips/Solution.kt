/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-09-24
 */
class Solution {
    fun minFlips(target: String): Int {
        var (prev, flip) = '0' to 0
        for (i in target.indices) {
            if (target[i] != prev) {
                prev = target[i]
                ++flip
            }
        }
        return flip
    }
}
