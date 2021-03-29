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
    private List<Integer> ans = new ArrayList<>();
    private int idx = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        return dfs(root, voyage) ? ans : Collections.singletonList(-1);
    }

    /*
    Approach: 재귀를 이용. dfs 는 voyage 대로 순회가 되고있으면 true, 아니면 false 를 리턴. root 가 null 이면 true, root.val 이 voyage 값과 다르면 false, root 의 왼쪽 자식 값이 다르면 오른쪽 자식과 flip 시도, 다 같으면 그대로 시도

    Time Complexity: O(N)
    Space Complexity: O(Height)
    */
    private boolean dfs(TreeNode root, int[] voyage) {
        if (root == null) {
            return true;
        } else if (root.val != voyage[idx++]) {
            return false;
        } else if (root.left != null && root.left.val != voyage[idx]) {
            ans.add(root.val);
            return dfs(root.right, voyage) && dfs(root.left, voyage);
        } else {
            return dfs(root.left, voyage) && dfs(root.right, voyage);
        }
    }
}
