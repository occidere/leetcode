/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode a = head, b = head;
        while (a != null && a.next != null) {
            if (a.next == head) {
                return true;
            }
            a = a.next;
            b.next = head;
            b = a;
        }
        return false;
    }
}
