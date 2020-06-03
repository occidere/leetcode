package main

func Min(a int, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}

/**
 * Definition for TreeNode.
 * type TreeNode struct {
 *     Val int
 *     Left *ListNode
 *     Right *ListNode
 * }
 */
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	a1, a2 := []*TreeNode{}, []*TreeNode{}
	getAncestors(root, p, &a1)
	getAncestors(root, q, &a2)

	minLen := Min(len(a1), len(a2))
	var lca *TreeNode
	for i := 0; i < minLen; i++ {
		if a1[i].Val == a2[i].Val {
			lca = a1[i]
		} else {
			break
		}
	}
	return lca
}

func getAncestors(root, target *TreeNode, ancestors *[]*TreeNode) {
	if root != nil {
		*ancestors = append(*ancestors, root)
		if target.Val < root.Val {
			getAncestors(root.Left, target, ancestors)
		} else if target.Val > root.Val {
			getAncestors(root.Right, target, ancestors)
		}
	}
}
