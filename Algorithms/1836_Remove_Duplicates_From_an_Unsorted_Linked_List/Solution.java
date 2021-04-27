import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        ListNode node = new ListNode(0, head);

        Map<Integer, Integer> freq = new HashMap<>();
        while (head != null) {
            freq.merge(head.val, 1, Integer::sum);
            head = head.next;
        }

        head = node;
        while (head != null) {
            ListNode next = head.next;
            while (next != null && freq.get(next.val) >= 2) {
                next = next.next;
            }
            head.next = next;
            head = head.next;
        }

        return node.next;
    }
}
