class Solution {
    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int) = if (mat.size * mat[0].size != r * c) mat else {
        Array(r) { IntArray(c) { 0 } }.apply {
            val (matIter, resIter) = IndexIterator(mat.size, mat[0].size) to IndexIterator(r, c)
            while (matIter.hasNext()) {
                val (i, j) = matIter.next()
                val (p, q) = resIter.next()
                this[p][q] = mat[i][j]
            }
        }
    }

    private data class IndexIterator(val m: Int, val n: Int) {
        private var i = 0
        private var j = 0

        fun next() = Pair(i, j).also {
            if (++j == n) {
                ++i
                j = 0
            }
        }

        fun hasNext() = i < m && j < n
    }
}
