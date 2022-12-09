/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-12-09
 */
class Solution {
    fun dayOfYear(date: String) = java.time.LocalDate.parse(date).dayOfYear
}
