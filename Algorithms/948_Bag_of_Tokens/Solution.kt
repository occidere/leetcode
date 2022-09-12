/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-09-12
 */
class Solution {
    fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
        tokens.sort()
        var maxScore = 0
        var (score, p) = 0 to power
        var (i, j) = 0 to tokens.size - 1
        while (i <= j) {
            if (tokens[i] <= p) {
                p -= tokens[i++]
                ++score
            } else if (0 < score) {
                p += tokens[j--]
                --score
            } else {
                break
            }
            maxScore = kotlin.math.max(maxScore, score)
        }
        return maxScore
    }
}
