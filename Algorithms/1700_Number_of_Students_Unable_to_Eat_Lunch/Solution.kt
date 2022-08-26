import java.util.*

/**
 * @author occidere
 * @Blog: https://blog.naver.com/occidere
 * @Github: https://github.com/occidere
 * @since 2022-08-26
 */
class Solution {
    fun countStudents(students: IntArray, sandwiches: IntArray): Int {
        val (q, stk) = students.toMutableList() to Stack<Int>().also { it.addAll(sandwiches.reversed()) }

        while (stk.isNotEmpty()) {
            var denyCount = 0
            val sandwich = stk.pop()
            while (denyCount < q.size && q.first() != sandwich) {
                ++denyCount
                q.add(q.removeAt(0))
            }

            if (denyCount == q.size) {
                return denyCount
            }
            q.removeAt(0)
        }

        return 0
    }
}
