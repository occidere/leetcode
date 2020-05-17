package main

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func sortedListToBST(head *ListNode) *TreeNode {
	var nodes []int
	for ; head != nil; head = head.Next {
		nodes = append(nodes, head.Val)
	}
	return dfs(nodes, 0, len(nodes) - 1)
}

func dfs(nodes []int, left int, right int) *TreeNode {
	if left <= right {
		mid := (left + right) / 2
		return &TreeNode{nodes[mid], dfs(nodes, left, mid-1), dfs(nodes, mid+1, right)}
	}
	return nil
}