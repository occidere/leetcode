/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-28
 */
class Solution {
    fun reformatNumber(number: String): String {
        val nums = number.filter { it in '0'..'9' }.toMutableList()
        val res = mutableListOf<String>()
        while (nums.size > 4) {
            val tmp = mutableListOf<Char>()
            repeat(3) {
                tmp.add(nums.removeAt(0))
            }
            res.add(tmp.joinToString(""))
        }
        if (nums.size == 4) {
            res.add(nums.take(2).joinToString(""))
            res.add(nums.takeLast(2).joinToString(""))
        } else {
            res.add(nums.joinToString(""))
        }

        return res.joinToString("-")
    }
}
