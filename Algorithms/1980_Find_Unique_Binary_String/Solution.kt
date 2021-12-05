class Solution {
    fun findDifferentBinaryString(nums: Array<String>) = nums.map { Integer.parseInt(it, 2) }
        .toSet()
        .run {
            (0..(1.shl(nums.size)))
                .filterNot { contains(it) }
                .first()
                .let {
                    with(Integer.toBinaryString(it)) {
                        0.until(nums.size - length).joinToString("") { "0" } + this
                    }
                }
        }
}
