/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-09-28
 */
class Solution {
    fun sortPeople(names: Array<String>, heights: IntArray) = names.indices
        .map { names[it] to heights[it] }
        .sortedByDescending { it.second }
        .map { it.first }
        .toTypedArray()
}
