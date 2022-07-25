/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-25
 */
class Solution {
    fun chalkReplacer(chalk: IntArray, k: Int): Int {
        var chalks = k.toLong() % chalk.map { it.toLong() }.sum()
        for (i in chalk.indices) {
            if (chalks < chalk[i]) {
                return i
            }
            chalks -= chalk[i]
        }
        return 0
    }
}
