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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root != null) {
            if (root.left == null && root.right == null && root.val == target) {
                return null;
            } else {
                root.left = removeLeafNodes(root.left, target);
                root.right = removeLeafNodes(root.right, target);
                if (root.val == target && root.left == null && root.right == null) {
                    return null;
                }
                return root;
            }
        }
        return null;
    }
}
