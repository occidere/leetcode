import kotlin.random.Random

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution(private var head: ListNode?) {
//    private val tmp = mutableListOf<Int>()
//    private val values = arrayListOf<Int>()
//    private var idx = 0
//
//    fun getRandom(): Int {
//        return if (values.isEmpty()) {
//            while (head != null) {
//                return head!!.`val`.apply {
//                    tmp += this
//                    head = head?.next
//                }
//            }
//            values.addAll(tmp)
//            getReservedValue()
//        } else {
//            getReservedValue()
//        }
//    }
//
//    private fun getReservedValue() = values[0.until(values.size).random()]

    fun getRandom(): Int {
        var node: ListNode? = head
        var (scope, selected) = 1 to 0
        while (node != null) {
            if (Random.nextDouble(0.0, 1.0) < 1.0 / scope) {
                selected = node.`val`
            }
            ++scope
            node = node.next
        }
        return selected
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(head)
 * var param_1 = obj.getRandom()
 */
