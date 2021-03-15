import java.util.ArrayList;
import java.util.List;

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

    public String tree2str(TreeNode t) {
        List<String> buf = new ArrayList<>();
        preorder(t, buf);
        String res = String.join("", buf);
        return res.substring(1, res.length() - 1);
    }

    private void preorder(TreeNode root, List<String> buf) {
        buf.add("(");
        if (root != null) {
            buf.add(root.val + "");
            if (root.left != null || root.right != null) {
                preorder(root.left, buf);
            }
            if (root.right != null) {
                preorder(root.right, buf);
            }
        }
        buf.add(")");
    }
}