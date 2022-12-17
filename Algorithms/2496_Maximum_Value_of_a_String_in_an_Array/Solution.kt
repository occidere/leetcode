/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-12-16
 */
class Solution {
    fun maximumValue(strs: Array<String>) = strs.map { it.toIntOrNull() ?: it.length }.max()!!
}
