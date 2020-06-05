package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func pathSum(root *TreeNode, sum int) [][]int {
    var paths [][]int
    if root != nil {
        dfs(root, sum, 0, []int{}, &paths)
    }
    return paths
}

func dfs(root *TreeNode, sum, acc int, path []int, paths *[][]int) {
    path, acc = append(path, root.Val), acc+root.Val
    if root.Left != nil {
        dfs(root.Left, sum, acc, path, paths)
    }
    if root.Right != nil {
        dfs(root.Right, sum, acc, path, paths)
    }
    if root.Left == nil && root.Right == nil && acc == sum {
        copied := make([]int, len(path), len(path))
        copy(copied, path)
        *paths = append(*paths, copied)
    }
}