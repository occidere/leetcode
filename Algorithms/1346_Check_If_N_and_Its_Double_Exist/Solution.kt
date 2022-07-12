/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-12
 */
class Solution {
    fun checkIfExist(arr: IntArray): Boolean {
        for (i in arr.indices) {
            for (j in arr.indices) {
                if (i != j && arr[i].shl(1) == arr[j]) {
                    return true
                }
            }
        }
        return false
    }
}
