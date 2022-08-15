/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-15
 */
class Solution {
    fun repeatedCharacter(s: String) =
        IntArray(26) { 0 }.let { visit ->
            s.forEach {
                if (++visit[it - 'a'] == 2) {
                    return it
                }
            }
            ' '
        }
}
