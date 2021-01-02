package main

func min(a int, b int) int {
	if a < b {
		return a
	}
	return b
}

func max(a int, b int) int {
	if a < b {
		return b
	}
	return a
}

func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func maxAncestorDiff(root *TreeNode) int {
	maxDiff := 0
	getMinMax(root, &maxDiff)
	return maxDiff
}

func getMinMax(root *TreeNode, maxDiff *int) (int, int) {
	minVal, maxVal := root.Val, root.Val

	if root.Left != nil {
		leftMin, leftMax := getMinMax(root.Left, maxDiff)
		minVal, maxVal = min(minVal, leftMin), max(maxVal, leftMax)
	}
	if root.Right != nil {
		rightMin, rightMax := getMinMax(root.Right, maxDiff)
		minVal, maxVal = min(minVal, rightMin), max(maxVal, rightMax)
	}

	*maxDiff = max(*maxDiff, max(abs(root.Val-minVal), abs(root.Val-maxVal)))
	return minVal, maxVal
}
