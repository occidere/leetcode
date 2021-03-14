package main

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func swapNodes(head *ListNode, k int) *ListNode {
	var nodeA, nodeB *ListNode
	for ptr, i := head, 1; ptr != nil; ptr, i = ptr.Next, i+1 {
		if nodeB != nil {
			nodeB = nodeB.Next
		}
		if i == k {
			nodeA = ptr
			nodeB = head
		}
	}

	nodeA.Val, nodeB.Val = nodeB.Val, nodeA.Val

	return head
}