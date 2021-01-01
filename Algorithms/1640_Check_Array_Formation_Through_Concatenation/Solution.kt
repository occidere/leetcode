class Solution {
    fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {
        val pieceMap = pieces.map { it.first() to it }.toMap()
        var i = 0

        while (i < arr.size) {
            val piece = pieceMap.getOrDefault(arr[i], intArrayOf())

            if (piece.isEmpty()) {
                return false
            }

            for (p in piece) {
                if (arr[i++] != p) {
                    return false
                }
            }
        }

        return true
    }
}