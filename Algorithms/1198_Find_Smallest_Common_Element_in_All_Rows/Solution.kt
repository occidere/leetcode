class Solution {
    fun smallestCommonElement(mat: Array<IntArray>): Int {
        var commons = mat[0].toSet()
        for (m in mat.drop(1)) {
            val c = commons.intersect(m.toSet())
            if (c.isEmpty()) return -1 else commons = c
        }
        return commons.sorted()[0]
    }
}