/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-11-19
 */
class Solution {
    fun threeConsecutiveOdds(arr: IntArray) =
        generateSequence(listOf(0, 1, 2)) { listOf(it[0] + 1, it[1] + 1, it[2] + 1) }
            .takeWhile { it[2] < arr.size }
            .any { (x, y, z) -> arr[x] % 2 == 1 && arr[y] % 2 == 1 && arr[z] % 2 == 1 }
}
