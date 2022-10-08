/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-10-01
 */
class Solution {
    fun minOperations(logs: Array<String>): Int {
        var depth = 0
        for (log in logs) {
            depth += when (log) {
                "../" -> if (depth == 0) 0 else -1
                "./" -> 0
                else -> 1
            }
        }
        return depth
    }
}
