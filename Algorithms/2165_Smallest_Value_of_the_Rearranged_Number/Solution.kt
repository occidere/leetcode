class Solution {
    fun smallestNumber(num: Long) = num.toString()
        .toCharArray()
        .let {
            if (it[0] == '-') "${it[0]}${it.drop(1).sortedDescending().joinToString("")}"
            else it.sorted().moveLeadingZeroes()
        }.toLong()

    private fun List<Char>.moveLeadingZeroes() = if (size == 1) "${first()}" else {
        var ended = -1
        for (i in indices) {
            if (this[i] != '0') {
                break
            }
            ended = i
        }
        if (ended == -1) joinToString("")
        else joinToString("").let {
            it[ended + 1] + it.substring(0, ended + 1) + it.substring(ended + 2)
        }
    }
}
