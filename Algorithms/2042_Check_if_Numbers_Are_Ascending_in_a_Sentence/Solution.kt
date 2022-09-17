/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-09-17
 */
class Solution {
    fun areNumbersAscending(s: String) = s.split(" ")
        .mapNotNull { it.toIntOrNull() }
        .zipWithNext()
        .all { it.first < it.second }
}
