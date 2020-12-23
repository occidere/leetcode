class Solution {
    private val visit = Array(8) { false }
    private val sequences = mutableSetOf<String>()

    fun numTilePossibilities(tiles: String, seq: String = ""): Int {
        sequences += seq
        for (i in tiles.indices) {
            if (!visit[i]) {
                visit[i] = true
                numTilePossibilities(tiles, seq + tiles[i])
                visit[i] = false
            }
        }
        return sequences.size - 1
    }
}