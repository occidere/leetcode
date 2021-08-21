class Solution {
    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>) =
        ((0 until n).toSet() - edges.map { it.last() }.toSet()).toList()
}
