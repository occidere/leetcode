class Solution {

    /*
    Approach: Window 사이즈 만큼 Map 에 카운팅하면서 key 값을 기록 (key 값이 곧 unique count)

    Time Complexity: O(N)
    Space Compelxity: O(N)
    
    */
    fun distinctNumbers(nums: IntArray, k: Int) =
        (0 until k).fold(mutableMapOf<Int, Int>()) { acc, i ->
            acc.merge(nums[i], 1, Integer::sum)
            acc
        }.let { freq ->
            IntArray(nums.size - k + 1)
                .also { it[0] = freq.keys.size }
                .also {
                    (1..nums.size - k).map { i ->
                        val (prev, cur) = nums[i - 1] to nums[k + i - 1]
                        freq.merge(prev, -1, Integer::sum)
                        if (freq[prev] == 0) {
                            freq.remove(prev)
                        }
                        freq.merge(cur, 1, Integer::sum)
                        it[i] = freq.keys.size
                    }
                }
        }
}

