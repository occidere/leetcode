/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     constructor()
 *
 *     // Constructor initializes a single integer.
 *     constructor(value: Int)
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     fun isInteger(): Boolean
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     fun getInteger(): Int?
 *
 *     // Set this NestedInteger to hold a single integer.
 *     fun setInteger(value: Int): Unit
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     fun add(ni: NestedInteger): Unit
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     fun getList(): List<NestedInteger>?
 * }
 */
class Solution {
    private var i = 0

    fun deserialize(s: String) =
        parse(s).run { if (s.startsWith("[")) getList().first() else this }

    private fun parse(s: String): NestedInteger {
        val (ni, sb) = NestedInteger() to StringBuilder()
        while (i < s.length) {
            when (val c = s[i++]) {
                '[' -> ni.add(parse(s))
                ']' -> {
                    sb.flushToInt()?.let { ni.add(NestedInteger(it)) }
                    return ni
                }
                ',' -> sb.flushToInt()?.let { ni.add(NestedInteger(it)) }
                else -> sb.append(c)
            }
        }
        sb.flushToInt()?.let { ni.setInteger(it) }
        return ni
    }

    private fun StringBuilder.flushToInt() =
        if (isEmpty()) null else toString().toInt().also { this.clear() }
}
