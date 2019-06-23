class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var left = head
        var right = head
        var move = 0

        while (true) {
            if (right?.next == null) {
                break
            }

            right = right.next
            if (move >= n) {
                left = left?.next
            }
            move++
        }

        return if (move + 1 == n) {
            head?.next
        } else {
            left?.next = if (left?.next != left?.next?.next) {
                left?.next?.next
            } else {
                null
            }
            head
        }
    }
}
