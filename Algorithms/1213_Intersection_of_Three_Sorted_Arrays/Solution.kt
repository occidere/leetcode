class Solution {
    fun arraysIntersection(arr1: IntArray, arr2: IntArray, arr3: IntArray): List<Int> =
        arr1.toSet().intersect(arr2.toSet()).intersect(arr3.toSet()).toList()
}

