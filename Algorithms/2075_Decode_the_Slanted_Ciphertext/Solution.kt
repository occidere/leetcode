class Solution {
    fun decodeCiphertext(encodedText: String, rows: Int): String {
        val cols = encodedText.length / rows
        val mat = Array(rows) { CharArray(cols) { 32.toChar() } }

        var (i, j) = 0 to 0
        encodedText.forEach {
            mat[i][j++] = it
            if (j >= cols) {
                j = 0
                ++i
            }
        }

        val decoded = mutableListOf<Char>()
        for (k in 0 until cols) {
            i = 0
            j = k
            while (i < rows && j < cols) {
                decoded += mat[i++][j++]
            }
        }
        return decoded.joinToString("").trimEnd()
    }
}
