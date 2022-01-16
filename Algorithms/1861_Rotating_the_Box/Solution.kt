class Solution {
    fun rotateTheBox(box: Array<CharArray>) = box.rotateRight().applyGravity()

    private fun Array<CharArray>.rotateRight() = this[0].indices
        .map { j ->
            indices.reversed()
                .map { i -> this[i][j] }
                .toCharArray()
        }.toTypedArray()

    private fun Array<CharArray>.applyGravity() = apply {
        for (j in first().indices) {
            var (stones, upperRow) = 0 to 0
            for (i in 0..size) {
                if (i == size || this[i][j] == '*') {
                    for (k in (i - 1).downTo(upperRow)) {
                        if (stones > 0) {
                            --stones
                            this[k][j] = '#'
                        } else {
                            this[k][j] = '.'
                        }
                    }
                    upperRow = i + 1
                } else if (this[i][j] == '#') {
                    ++stones
                }
            }
        }
    }
}
