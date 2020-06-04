package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func generateTrees(n int) []*TreeNode {
    if n == 0 {
        return []*TreeNode{}
    }
    return generateSubtrees(1, n)
}

func generateSubtrees(s, e int) []*TreeNode {
    if s > e {
        return []*TreeNode{nil}
    }

    var res []*TreeNode
    for i := s; i <= e; i++ {
        leftSub := generateSubtrees(s, i-1)
        rightSub := generateSubtrees(i+1, e)

        for _, left := range leftSub {
            for _, right := range rightSub {
                res = append(res, &TreeNode{i, left, right})
            }
        }
    }
    return res
}