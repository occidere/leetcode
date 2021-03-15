import java.util.LinkedList;
import java.util.Queue;

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
    private int idx = 0;

    public TreeNode str2tree(String s) {
        if (s.length() == 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        TreeNode root = new TreeNode();
        while (idx < s.length()) {
            char c = s.charAt(idx++);
            if (c == '(') {
                if (root.left == null) {
                    root.left = str2tree(s);
                } else {
                    root.right = str2tree(s);
                }
            } else if (c == ')') {
                break;
            } else {
                sb.append(c);
            }
        }
        root.val = Integer.parseInt(sb.toString());

        return root;
    }
}