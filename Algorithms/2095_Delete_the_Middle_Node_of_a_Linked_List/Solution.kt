/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 *
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-10-14
 */
class Solution {
    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return null
        }
        var (prev, slow, fast) = Triple<ListNode?, ListNode?, ListNode?>(null, head, head)
        while (fast?.next != null) {
            prev = slow
            slow = slow?.next
            fast = fast.next?.next
        }
        prev?.next = slow?.next
        return head
    }
}
