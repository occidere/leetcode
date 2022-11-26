/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-11-26
 */
class Solution {
    fun convertTime(current: String, correct: String): Int {
        val diffMinutes = correct.toMinutes() - current.toMinutes()
        return (diffMinutes / 60) + ((diffMinutes % 60) / 15) + (((diffMinutes % 60) % 15) / 5) + (((diffMinutes % 60) % 15) % 5)
    }

    private fun String.toMinutes() = split(":").map { it.toInt() }.let { it[0] * 60 + it[1] }
}
