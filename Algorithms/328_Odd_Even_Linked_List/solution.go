package main

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func oddEvenList(head *ListNode) *ListNode {
	if head != nil {
		oddHead := head
		even := &ListNode{} // fake node
		evenHead := even

		for isEven, cur := true, oddHead.Next; cur != nil; isEven, cur = !isEven, cur.Next {
			if isEven {
				even.Next = cur
				even = even.Next
			} else {
				oddHead.Next = cur
				oddHead = cur
			}
		}

		oddHead.Next, even.Next = evenHead.Next, nil
	}

	return head
}