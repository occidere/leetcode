/**
 * @author occidere
 * @since 2019-06-22
 * Blog: https://blog.naver.com/occidere
 * Github: https://github.com/occidere
 */
class Solution {
    private val digitList: MutableList<String> = mutableListOf()
    private val pad: Map<Char, List<Char>> = mapOf(
            '2' to listOf('a', 'b', 'c'), '3' to listOf('d', 'e', 'f'),
            '4' to listOf('g', 'h', 'i'), '5' to listOf('j', 'k', 'l'), '6' to listOf('m', 'n', 'o'),
            '7' to listOf('p', 'q', 'r', 's'), '8' to listOf('t', 'u', 'v'), '9' to listOf('w', 'x', 'y', 'z')
    )

    fun letterCombinations(digits: String): List<String> {
        for (i in 0 until digits.length) {
            val nums = StringBuilder()
            for (ch: Char in pad.getValue(digits[i])) {
                nums.append(ch)
                dfs(digits, i + 1, nums)
                nums.deleteCharAt(nums.length - 1)
            }
        }
        return digitList.toList()
    }

    private fun dfs(digits: String, cur: Int, nums: StringBuilder) {
        if (cur == digits.length) {
            if (nums.length == digits.length) {
                digitList.add(nums.toString())
            }
            return
        }

        for (i in cur until digits.length) {
            for (ch: Char in pad.getValue(digits[i])) {
                nums.append(ch)
                dfs(digits, i + 1, nums)
                nums.deleteCharAt(nums.length - 1)
            }
        }
    }
}
