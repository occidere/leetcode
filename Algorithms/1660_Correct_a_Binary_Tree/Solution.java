import java.util.*;

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
    private final Set<TreeNode> visit = new HashSet<>();

    public TreeNode correctBinaryTree(TreeNode root) {
        visit.add(root);
        if (root.right != null) {
            if (visit.contains(root.right)) {
                return null;
            } else {
                root.right = correctBinaryTree(root.right);
            }
        }
        if (root.left != null) {
            root.left = correctBinaryTree(root.left);
        }
        return root;
    }
}
