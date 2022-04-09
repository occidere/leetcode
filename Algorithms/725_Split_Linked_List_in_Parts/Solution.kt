/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        var (n, node) = 0 to head
        while (node != null) {
            node = node.next
            ++n
        }
        node = head

        val (quotient, remainder) = n / k to n % k
        return 0.until(k)
            .map { if (it < remainder) quotient + 1 else quotient }
            .map {
                node?.apply {
                    repeat(it - 1) { node = node?.next }
                    val next = node?.next
                    node?.next = null
                    node = next
                }
            }.toTypedArray()
    }
}
