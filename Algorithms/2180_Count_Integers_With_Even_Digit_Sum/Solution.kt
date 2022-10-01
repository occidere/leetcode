/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-10-01
 */
class Solution {
    fun countEven(num: Int) = (1..num).count { n -> "$n".sumBy { it - '0' } % 2 == 0 }
}
