/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-12-21
 */
class Solution {
    fun bestClosingTime(customers: String): Int {
        var penalty = 1 + customers.sumBy { if (it == 'Y') 1 else 0 }
        return "Y$customers".asSequence()
            .withIndex()
            .map { (i, c) -> i to if (c == 'Y') --penalty else ++penalty }
            .minWith(Comparator { xs, ys -> if (xs.second == ys.second) xs.first - ys.first else xs.second - ys.second })!!
            .first
    }
}
