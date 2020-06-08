package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func constructMaximumBinaryTree(nums []int) *TreeNode {
	maxPos := getMaxPos(nums)
	root := &TreeNode{Val: nums[maxPos]}
	if maxPos > 0 {
		root.Left = constructMaximumBinaryTree(nums[0:maxPos])
	}
	if maxPos < len(nums)-1 {
		root.Right = constructMaximumBinaryTree(nums[maxPos+1:])
	}
	return root
}

func getMaxPos(nums []int) int {
	maxPos, maxVal := 0, nums[0]
	for i := 1; i < len(nums); i++ {
		if maxVal < nums[i] {
			maxPos, maxVal = i, nums[i]
		}
	}
	return maxPos
}