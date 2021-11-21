class Solution {
    fun countBalls(lowLimit: Int, highLimit: Int) = lowLimit.rangeTo(highLimit)
        .map { it.toString() }
        .groupBy { it.map { it - '0' }.sum() }
        .map { it.value.size }
        .max()!!
}
