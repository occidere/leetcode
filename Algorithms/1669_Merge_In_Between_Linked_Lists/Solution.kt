/**
 * @author occidere
 * @Github: https://github.com/occidere
 * @Blog: https://blog.naver.com/occidere
 * @since 2020-12-02
 */

/*
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
        lateinit var endOfL1: ListNode
        var head = list1
        for (i in 0..b) {
            if (i == a - 1) {
                endOfL1 = head!!
            }
            head = head!!.next
        }
        val startOfL1 = head

        head = list2
        while (head!!.next != null) {
            head = head.next
        }
        val endOfL2 = head

        endOfL1.next = list2
        endOfL2.next = startOfL1

        return list1
    }
}