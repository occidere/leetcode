# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from typing import List


class Solution:

	def kthSmallest(self, root: TreeNode, k: int) -> int:
		arr: List[int] = []
		self.inorder(root, arr)
		return arr[k - 1]

	def inorder(self, root: TreeNode, arr: List[int]) -> None:
		if root is not None:
			self.inorder(root.left, arr)
			arr.append(root.val)
			self.inorder(root.right, arr)
