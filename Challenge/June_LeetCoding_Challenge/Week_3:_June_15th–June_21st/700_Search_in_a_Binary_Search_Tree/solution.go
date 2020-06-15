package main

type Queue struct {
    queue []*TreeNode
}

func (q *Queue) Offer(node *TreeNode) {
    q.queue = append(q.queue, node)
}

func (q *Queue) Poll() *TreeNode {
    root := q.queue[0]
    q.queue = q.queue[1:]
    return root
}

func (q *Queue) isEmpty() bool {
    return len(q.queue) == 0
}

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func searchBST(root *TreeNode, val int) *TreeNode {
    q := Queue{}
    q.Offer(root)

    for !q.isEmpty() {
        node := q.Poll()
        if node.Val == val {
            return node
        }
        if node.Left != nil {
            q.Offer(node.Left)
        }
        if node.Right != nil {
            q.Offer(node.Right)
        }
    }

    return nil
}