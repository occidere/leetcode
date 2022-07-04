class Solution {
    fun average(salary: IntArray) =
        salary.sorted().drop(1).dropLast(1).average()
}
