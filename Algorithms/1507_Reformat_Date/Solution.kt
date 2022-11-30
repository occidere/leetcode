/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-11-30
 */
class Solution {
    fun reformatDate(date: String) = date.split(" ")
        .let { (dd, mm, yy) ->
            "$yy-" + (arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec").withIndex()
                .find { it.value == mm }!!.index + 1).let { if (it < 10) "0$it" else "$it" } +
                    "-" + dd.replace(Regex("[^0-9]*"), "").let { if (it.length < 2) "0$it" else it }
        }
}
