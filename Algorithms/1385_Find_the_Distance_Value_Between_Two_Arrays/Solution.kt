/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-06
 */
class Solution {
    fun findTheDistanceValue(arr1: IntArray, arr2: IntArray, d: Int): Int {
        arr2.sort()
        var ans = arr1.size
        for (a in arr1) {
            for (b in arr2) {
                if (kotlin.math.abs(a - b) <= d) {
                    --ans
                    break
                }
            }
        }
        return ans
    }
}
