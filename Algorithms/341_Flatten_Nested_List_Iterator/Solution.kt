import java.util.*

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

class NestedIterator(nestedList: List<NestedInteger>) {
    private var idx = 0
    private var niList = nestedList
    private val stk = Stack<Pair<List<NestedInteger>, Int>>()

    fun next(): Int = niList[idx++].getInteger()!!.apply { hasNext() }

    fun hasNext(): Boolean {
        while (true) when {
            idx < niList.size -> when {
                niList[idx].isInteger() -> return true
                niList[idx].getList()!!.isEmpty() -> ++idx
                else -> {
                    stk.push(Pair(niList, idx + 1))
                    niList = niList[idx].getList()!!
                    idx = 0
                }
            }
            stk.isNotEmpty() -> stk.pop().apply {
                niList = this.first
                idx = this.second
            }
            else -> return false
        }
    }
}