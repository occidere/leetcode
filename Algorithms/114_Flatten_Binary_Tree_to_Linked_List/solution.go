package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func flatten(root *TreeNode) {
    prev = nil
    dfs(root)
}

var prev *TreeNode

func dfs(root *TreeNode) {
    if root != nil {
        dfs(root.Right)
        dfs(root.Left)
        root.Right, root.Left = prev, nil
        prev = root
    }
}