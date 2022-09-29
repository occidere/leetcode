/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-09-29
 */
class Solution {
    fun totalMoney(n: Int): Int {
        val weekSum = 28
        var (days, week, money) = Triple(n, 0, 0)
        while (days >= 7) {
            money += weekSum + (7 * week++)
            days -= 7
        }
        return money + (week + 1 until week + 1 + days).sum()
    }
}
