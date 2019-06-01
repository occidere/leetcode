/**
 * @author occidere
 * @since 2019-06-01
 * Blog: https://blog.naver.com/occidere
 * Github: https://github.com/occidere
 */
class Solution {
    private val roman: HashMap<Int, String> = hashMapOf(
        1 to "I", 5 to "V", 10 to "X",
        50 to "L", 100 to "C", 500 to "D", 1000 to "M"
    )

    fun intToRoman(num: Int): String {
        val strNum = num.toString()
        var k = pow(strNum.length - 1)
        val romanNum = StringBuilder()
        for (c in strNum) {
            val n = c.toInt() - 48
            val r = StringBuilder()

            when {
                n == 4 -> r.append(roman[1 * k] + roman[5 * k])
                n == 9 -> r.append(roman[1 * k] + roman[10 * k])
                n == 5 -> r.append(roman[5 * k]!!)
                n < 5 -> for (i in 1..n) {
                    r.append(roman[1 * k])
                }
                else -> {
                    r.append(roman[5 * k] + r)
                    for (i in 1..n - 5) {
                        r.append(roman[1 * k])
                    }
                }
            }
            romanNum.append(r)
            k /= 10
        }
        return romanNum.toString()
    }

    private fun pow(n: Int): Int {
        var k = 1
        for (i in 1..n) {
            k *= 10
        }
        return k
    }
}
