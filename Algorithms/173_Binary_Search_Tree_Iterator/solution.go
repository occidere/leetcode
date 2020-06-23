package main

type Stack struct {
	stk []*TreeNode
}

func (s *Stack) IsEmpty() bool {
	return len(s.stk) == 0
}

func (s *Stack) Push(node *TreeNode) {
	s.stk = append(s.stk, nil)
	copy(s.stk[1:], s.stk[0:])
	s.stk[0] = node
}

func (s* Stack) Pop() *TreeNode {
	top := s.stk[0]
	s.stk = s.stk[1:]
	return top
}

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
type BSTIterator struct {
	stack Stack
}

func Constructor(root *TreeNode) BSTIterator {
	bstIterator := BSTIterator{}
	for root != nil {
		bstIterator.stack.Push(root)
		root = root.Left
	}
	return bstIterator
}

/** @return the next smallest number */
func (it *BSTIterator) Next() int {
	top := it.stack.Pop()
	val := top.Val

	top = top.Right
	if top != nil {
		it.stack.Push(top)
		for top = top.Left; top != nil; top = top.Left {
			it.stack.Push(top)
		}
	}

	return val
}

/** @return whether we have a next smallest number */
func (it *BSTIterator) HasNext() bool {
	return !it.stack.IsEmpty()
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * obj := Constructor(root);
 * param_1 := obj.Next();
 * param_2 := obj.HasNext();
 */