/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-04
 */
class Solution {
    fun candy(ratings: IntArray) = ratings.zip(ratings.indices)
        .sortedBy { it.first }
        .map { it.second }
        .let { sortedIndices ->
            IntArray(ratings.size) { 1 }
                .also { candies ->
                    sortedIndices.forEach { idx ->
                        if (0 < idx && ratings[idx - 1] < ratings[idx]) {
                            candies[idx] = kotlin.math.max(candies[idx], candies[idx - 1] + 1)
                        }
                        if (idx < ratings.size - 1 && ratings[idx] > ratings[idx + 1]) {
                            candies[idx] = kotlin.math.max(candies[idx], candies[idx + 1] + 1)
                        }
                    }
                }.sum()
        }
}
