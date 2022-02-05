class Solution {
    /*
    left ~ mid, mid ~ right 의 범위 중 회전이 안된 부분을 찾아 이진 탐색 수행

    Time Complexity: O(logn) ~ O(n)
    Space Complexity: O(1)
     */
    fun search(nums: IntArray, target: Int): Boolean {
        var (left, right) = 0 to nums.size - 1

        while (left <= right) {
            val mid = (left + right).shr(1)
            if (nums[mid] == target) {
                return true // 찾음
            }

            if (nums[left] == nums[mid] && nums[mid] == nums[right]) { // 중복수 제거
                ++left
                --right
            } else if (nums[left] <= nums[mid]) { // left ~ mid 까지는 회전 안된 정상 정렬 상태 -> 이 구간 이진 탐색 가능
                if (nums[left] <= target && target < nums[mid]) { // target 이 left ~ mid 사이에 있음
                    right = mid - 1
                } else {
                    // target 이 left 보다 작거나, mid 보다 큼
                    // left: 0, right: size - 1 부터 시작하므로, target 이 left 보다 작은 경우는 X
                    // => target 이 mid 보다 큼
                    left = mid + 1
                }
            } else { // left ~ mid 사이에 회전 기준점 (pivot) 이 존재 -> 이 구간은 이진 탐색 불가 & mid ~ right 은 정상
                if (nums[mid] < target && target <= nums[right]) { // target 이 mid ~ right 사이에 있음
                    left = mid + 1
                } else {
                    // target 이 mid 보다 작거나, right 보다 큼
                    // left: 0, right: size - 1 부터 시작하므로, target 이 right 보다 큰 경우는 X
                    // => target 이 mid 보다 작음
                    right = mid - 1
                }
            }
        }
        return false
    }

    /*
    pivot 을 먼저 찾은 뒤, 0 ~ pivot 과 pivot ~ n 에 각각 이진 탐색 수행

    Time Complexity: O(logn) ~ O(n)
    Space Complexity: O(1)
     */
//    fun search(nums: IntArray, target: Int): Boolean {
//        fun getPivotPos(left: Int, right: Int): Int {
//            if (left + 1 >= right) {
//                return Int.MIN_VALUE
//            }
//
//            val mid = (left + right).shr(1)
//            return if (mid != 0 && nums[mid - 1] > nums[mid]) {
//                mid
//            } else if (mid != nums.size - 1 && nums[mid] > nums[mid + 1]) {
//                mid + 1
//            } else {
//                kotlin.math.max(getPivotPos(left, mid), getPivotPos(mid, right)) // INF or pivot idx
//            }
//        }
//
//        val pivotIdx = kotlin.math.max(0, getPivotPos(0, nums.size))
//        return if (pivotIdx == 0) {
//            nums.binarySearch(target) >= 0
//        } else {
//            nums.binarySearch(target, 0, pivotIdx) >= 0 || nums.binarySearch(target, pivotIdx, nums.size) >= 0
//        }
//    }
}
