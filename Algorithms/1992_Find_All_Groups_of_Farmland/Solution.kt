class Solution {
    fun findFarmland(land: Array<IntArray>): Array<IntArray> {
        val farmlands = mutableListOf<IntArray>()
        for (i in land.indices) {
            for (j in land[i].indices) {
                if (land[i][j] == 1) {
                    farmlands += land.farmlandCoordinatesStartWith(i, j)
                }
            }
        }
        return farmlands.toTypedArray()
    }

    private fun Array<IntArray>.farmlandCoordinatesStartWith(a: Int, b: Int): IntArray {
        this[a][b] = 0
        var idx = 0
        val coordinates = mutableListOf(intArrayOf(a, b))
        while (idx < coordinates.size) {
            coordinates += this.nextFarmlandCoordinatesFrom(coordinates[idx++])
        }
        return minMaxCoordinatesOf(coordinates)
    }

    private fun Array<IntArray>.nextFarmlandCoordinatesFrom(cur: IntArray) = nextCoordinates(cur)
        .filter { it.isValidFarmlandCoordinateOf(this) }
        .toMutableList()
        .onEach { this[it[0]][it[1]] = 0 }

    private fun nextCoordinates(cur: IntArray): Sequence<IntArray> {
        val (dx, dy) = intArrayOf(-1, 1, 0, 0) to intArrayOf(0, 0, -1, 1)
        return 0.until(4).map { intArrayOf(cur[0] + dx[it], cur[1] + dy[it]) }.asSequence()
    }

    private fun IntArray.isValidFarmlandCoordinateOf(land: Array<IntArray>) = isInRangeOf(land) && isFarmlandOf(land)

    private fun IntArray.isInRangeOf(land: Array<IntArray>) = this[0] in land.indices && this[1] in land[0].indices

    private fun IntArray.isFarmlandOf(land: Array<IntArray>) = land[this[0]][this[1]] == 1

    private fun minMaxCoordinatesOf(coordinates: List<IntArray>) = coordinates
        .sortedWith(Comparator { x, y -> if (x[0] == y[0]) x[1] - y[1] else x[0] - y[0] })
        .run { if (isEmpty()) intArrayOf() else intArrayOf(this[0][0], this[0][1], last()[0], last()[1]) }
}
