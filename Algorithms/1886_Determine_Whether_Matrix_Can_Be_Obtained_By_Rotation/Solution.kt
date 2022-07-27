/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-07-27
 */
class Solution {
    fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
        val t = target.flattenString()
        val (a, b) = mat.flattenString().let { it to it.reversed() }
        val (c, d) = mat.indices
            .flatMap { j -> mat.indices.reversed().map { i -> mat[i][j] } }
            .joinToString("")
            .let { it to it.reversed() }
        return t == a || t == b || t == c || t == d
    }

    private fun Array<IntArray>.flattenString() = joinToString("") { it.joinToString("") }
}
