class Solution {
    fun shiftGrid(grid: Array<IntArray>, k: Int) = IntArray(grid.size * grid.first().size) { 0 }
        .also {
            var idx = 0
            for (i in grid.indices) {
                for (j in grid.first().indices) {
                    it[idx++] = grid[i][j]
                }
            }
        }.let {
            val shifted = IntArray(it.size) { 0 }
            var (i, j) = 0 to (shifted.size - (k % shifted.size)) % shifted.size
            while (i < shifted.size) {
                shifted[i++] = it[j]
                j = (j + 1) % shifted.size
            }
            shifted
        }.let {
            var idx = 0
            val shifted2d = Array(grid.size) { IntArray(grid.first().size) { 0 } }
            for (i in shifted2d.indices) {
                for (j in shifted2d.first().indices) {
                    shifted2d[i][j] = it[idx++]
                }
            }
            shifted2d
        }.map { it.toList() }
}
