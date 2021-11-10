class Solution {
    fun minMovesToSeat(seats: IntArray, students: IntArray) = seats.sorted()
        .zip(students.sorted())
        .map { kotlin.math.abs(it.first - it.second) }
        .sum()
}
