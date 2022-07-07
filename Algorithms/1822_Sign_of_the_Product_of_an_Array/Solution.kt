/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-07
 */
class Solution {
    fun arraySign(nums: IntArray) = nums.map { if (it < 0) -1 else if (it > 0) 1 else 0 }
        .groupBy { it }
        .mapValues { it.value.size }
        .let { if (it.contains(0)) 0 else if (it.getOrDefault(-1, 0) % 2 == 0) 1 else -1 }
}
