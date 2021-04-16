/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        return preorder(root, -0x3f3f3f3f);
    }

    private int preorder(TreeNode root, int maxVal) {
        return root == null ? 0 : (root.val >= maxVal ? 1 : 0) 
            + preorder(root.left, Math.max(root.val, maxVal))
            + preorder(root.right, Math.max(root.val, maxVal));
    }
}
