class Solution {
    fun minimumSum(num: Int) = num.toString()
        .toCharArray()
        .sorted()
        .let { "${it[0]}${it[2]}".toInt() + "${it[1]}${it[3]}".toInt() }
}
