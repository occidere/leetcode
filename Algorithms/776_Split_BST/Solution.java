/*
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
    public TreeNode[] splitBST(TreeNode root, int V) {
        // { V보다 작거나 같은 노드들, V보다 큰 노드들 }
        if (root == null) {
            return new TreeNode[]{null, null};
        }

        if (root.val <= V) {
            TreeNode[] nodes = splitBST(root.right, V);
            root.right = nodes[0];
            return new TreeNode[]{root, nodes[1]};
        } else {
            TreeNode[] nodes = splitBST(root.left, V);
            root.left = nodes[1];
            return new TreeNode[]{nodes[0], root};
        }
    }
}