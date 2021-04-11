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
    Approach: 현재, 왼쪽, 오른쪽을 순회하면서 subtree 여부 체크

    Time Complexity: O(M * N). M = s 노드개수, N = t 노드개수
    Space Complexity: O(M). M = s 노드개수
    */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return s != null && (isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
    }

    // 둘다 null 이 아니면서 현재, 왼쪽, 오른쪽 값이 모두 같은지 체크
    private boolean isSame(TreeNode s, TreeNode t) {
        if ((s == null && t != null) || (s != null && t == null)) {
            return false;
        } else if (s == null && t == null) {
            return true;
        }
        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
