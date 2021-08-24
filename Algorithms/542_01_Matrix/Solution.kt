class Solution {
    fun updateMatrix(mat: Array<IntArray>) = mat.also {
        val (dx, dy) = intArrayOf(-1, 1, 0, 0) to intArrayOf(0, 0, -1, 1)
        val (m, n) = mat.indices to mat[0].indices
        val q = m.flatMap { i ->
            n.map { j ->
                if (mat[i][j] == 0) Pair(i, j) else {
                    mat[i][j] = 0x3f3f3f3f
                    null
                }
            }
        }.filterNotNull()
            .toMutableList()
        while (q.isNotEmpty()) {
            val (x, y) = q.removeAt(0)
            for (i in 0 until 4) {
                val (ax, ay) = Pair(x + dx[i], y + dy[i])
                if (ax in m && ay in n && mat[x][y] < mat[ax][ay]) {
                    q += Pair(ax, ay)
                    mat[ax][ay] = mat[x][y] + 1
                }
            }
        }
    }
}
