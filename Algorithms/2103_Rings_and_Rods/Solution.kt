class Solution {
    fun countPoints(rings: String) = (0.until(rings.length).step(2))
        .groupBy({ i -> rings[i + 1] }, { i -> rings[i] })
        .filter { it.value.toSet().size == 3 }
        .keys
        .size
}
