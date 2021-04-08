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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        } else if (p.val < root.val) {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : (left.val < root.val ? left : root);
        } else {
            return inorderSuccessor(root.right, p);
        }
    }
}
