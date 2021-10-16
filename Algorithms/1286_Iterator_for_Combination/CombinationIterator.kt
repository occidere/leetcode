import java.util.*

class CombinationIterator(
    private val characters: String,
    private val combinationLength: Int
) {
    private val stk = Stack<Int>().apply { addAll(0 until combinationLength) }

    fun next(): String = stk.map { characters[it] }
        .joinToString("")
        .also { update() }

    fun hasNext() = stk.isNotEmpty()

    private fun update() {
        while (stk.isNotEmpty()) {
            var lastUpdated = stk.pop()
            while (lastUpdated + 1 < characters.length && stk.size < combinationLength) {
                stk.push(++lastUpdated)
            }
            if (stk.size == combinationLength) {
                break
            }
        }
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * var obj = CombinationIterator(characters, combinationLength)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */
