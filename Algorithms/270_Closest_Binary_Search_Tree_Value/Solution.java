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

    public int closestValue(TreeNode root, double target) {
        int num = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(num - target)) {
                num = root.val;
            }
            root = target < root.val ? root.left : root.right;
        }
        return num;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(new Solution().closestValue(root, 3.428571));
    }
}