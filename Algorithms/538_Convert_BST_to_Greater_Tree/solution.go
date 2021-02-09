package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func convertBST(root *TreeNode) *TreeNode {
    rightOrder(root, 0)
    return root
}

func rightOrder(root *TreeNode, acc int) int {
    if root != nil {
        rightVal := rightOrder(root.Right, acc)
        leftVal := rightOrder(root.Left, root.Val + rightVal)
        root.Val+= rightVal
        return leftVal
    }
    return acc
}