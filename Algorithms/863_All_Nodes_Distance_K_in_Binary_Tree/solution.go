package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

var (
    graph [][]int
    k     int
)

func distanceK(root *TreeNode, target *TreeNode, K int) []int {
    k = K
    ans := make([]int, 0, 501)
    visit := make([]bool, 501, 501)
    graph = make([][]int, 501, 501)
    for i := 0; i <= 500; i++ {
        graph[i] = []int{}
    }

    buildGraph(root)
    visit[target.Val] = true
    dfs(target.Val, 0, visit, &ans)

    return ans
}

func buildGraph(root *TreeNode) {
    if root.Left != nil {
        graph[root.Val] = append(graph[root.Val], root.Left.Val)
        graph[root.Left.Val] = append(graph[root.Left.Val], root.Val)
        buildGraph(root.Left)
    }
    if root.Right != nil {
        graph[root.Val] = append(graph[root.Val], root.Right.Val)
        graph[root.Right.Val] = append(graph[root.Right.Val], root.Val)
        buildGraph(root.Right)
    }
}

func dfs(node, move int, visit []bool, ans *[]int) {
    if move <= k {
        if move == k {
            *ans = append(*ans, node)
            return
        }

        for _, next := range graph[node] {
            if !visit[next] {
                visit[next] = true
                dfs(next, move+1, visit, ans)
                visit[next] = false
            }
        }
    }
}