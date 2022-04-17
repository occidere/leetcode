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
    private final TreeNode fakeNode = new TreeNode(-1);
    private TreeNode head = fakeNode;

    public TreeNode increasingBST(TreeNode root) {
        if (root != null) {
            increasingBST(root.left);
            head.right = root;
            head = head.right;
            head.left = null;
            increasingBST(root.right);
        }
        return fakeNode.right;
    }
}
