/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-19
 */
class Solution {
    fun buildArray(target: IntArray, n: Int): List<String> {
        var k = 1
        val ops = mutableListOf<String>()
        for (t in target) {
            repeat(t - k) {
                ops.add("Push")
                ops.add("Pop")
                ++k
            }
            ops.add("Push")
            ++k
        }
        return ops
    }
}
