/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return find(preorder, inorder, 0, inorder.length);
    }

    private TreeNode find(int[] preorder, int[] inorder, int left, int right) {
        TreeNode node = null;
        for (int i = left; i < right; ++i) {
            if (preorder[idx] == inorder[i]) {
                node = new TreeNode(preorder[idx++]);
                node.left = find(preorder, inorder, left, i);
                node.right = find(preorder, inorder, i + 1, right);
                break;
            }
        }
        return node;
    }
}
