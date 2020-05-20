package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func kthSmallest(root *TreeNode, k int) int {
    order, ans, finished := 0, 0, false
    inorder(root, k, &order, &ans, &finished)
    return ans
}

func inorder(root *TreeNode, k int, order *int, ans *int, finished *bool) {
    if !*finished && root != nil {
        inorder(root.Left, k, order, ans, finished)
        *order++
        if *order == k {
            *ans, *finished = root.Val, true
            return
        }
        inorder(root.Right, k, order, ans, finished)
    }
}