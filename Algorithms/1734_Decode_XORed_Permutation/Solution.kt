/*
ref: https://leetcode.com/problems/decode-xored-permutation/discuss/1031840/Explanations-XOR-and-1st-element-Java-Kotlin-Python
 */
class Solution {
    fun decode(encoded: IntArray): IntArray {
        var first = (1..encoded.size + 1).reduce { acc, i -> acc xor i }
        for (i in 1.until(encoded.size).step(2)) {
            first = first xor encoded[i]
        }
        val ans = IntArray(encoded.size + 1) { first }
        for (i in encoded.indices) {
            ans[i + 1] = ans[i] xor encoded[i]
        }
        return ans
    }
}
