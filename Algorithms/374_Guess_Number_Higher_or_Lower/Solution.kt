/**
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num:Int):Int {}
 */
class Solution : GuessGame() {
    override fun guessNumber(n: Int): Int {
        var (high: Long, low: Long) = n.toLong() to 1L
        while (true) {
            val mid = (high + low).shr(1).toInt()
            when (guess(mid)) {
                -1 -> high = mid - 1L
                1 -> low = mid + 1L
                else -> return mid
            }
        }
    }
}
