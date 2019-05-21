class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	int a = l1.val, b = l2.val, sum = (a + b) % 10, k = (a + b) / 10;
	ListNode cur = new ListNode(sum), listNode = cur;
	do {
	    a = b = 0;
	    if (l1.next == null && l2.next == null) {
		if (k > 0) {
		    cur.next = new ListNode(k);
		}
		break;
	    }

	    if (l1.next != null) {
		l1 = l1.next;
		a = l1.val;
	    }
	    if (l2.next != null) {
		l2 = l2.next;
		b = l2.val;
	    }

	    sum = (a + b + k) % 10;
	    k = (a + b + k) / 10;


	    cur.next = new ListNode(sum);
	    cur = cur.next;
	} while (true);

	return listNode;
    }
}
