import kotlin.math.abs
import kotlin.math.min

class Solution {
    fun angleClock(hour: Int, minutes: Int): Double =
            abs(minutes * 6 - (hour * 60 + minutes) * .5).let { min(it, abs(360 - it)) }
}