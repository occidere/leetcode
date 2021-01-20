import java.util.*
import kotlin.math.max

class Solution {
    fun maxDepth(s: String): Int {
        var maxCount = 0
        var count = 0

        for (c in s) {
            if (c == '(') maxCount = max(maxCount, ++count)
            else if (c == ')') --count
        }

        return maxCount
    }
}