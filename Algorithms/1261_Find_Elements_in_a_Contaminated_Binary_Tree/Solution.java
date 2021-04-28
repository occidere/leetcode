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
class FindElements {

    private Set<Integer> values = new HashSet<>();

    public FindElements(TreeNode root) {
        preorder(root, 0);
    }

    public boolean find(int target) {
        return values.contains(target);
    }

    private void preorder(TreeNode root, int val) {
        if (root != null) {
            root.val = val;
            values.add(val);
            preorder(root.left, (val << 1) + 1);
            preorder(root.right, (val << 1) + 2);
        }
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
