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

    /*
    Approach: 트리 탐색하면서 {노드 누적값, 노드개수, 평균 값 중 최대값} 을 반환
   
    Time Complexity: O(N). N 은 노드 개수
    Space Complexity: O(N)
    */
    public double maximumAverageSubtree(TreeNode root) {
        return traversal(root)[2];
    }

    private double[] traversal(TreeNode root) {
        if (root != null) {
            double[] l = traversal(root.left);
            double[] r = traversal(root.right);
            return new double[]{
                root.val + l[0] + r[0],
                1 + l[1] + r[1],
                Math.max(
                    Math.max(l[2], r[2]),
                    (root.val + l[0] + r[0]) / (1 + l[1] + r[1])
                )
            };
        }
        return new double[]{0, 0, 0};
    }
}
