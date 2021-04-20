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

    /*
    Approach: Stack을 사용해서 Iterative 하게 접근
        - fakeNode를 두고 right->root가 되도록 설정한 뒤 stk에 push
        - stk.pop()해서 나온 현재 노드에서 right가 있으면 right로 한번 이동한 뒤, 쭉 left 타고 내려가면서 ans와 stk에 추가
        - 위 과정 반복

    Time Complexity: O(N)
    Space Complexity: O(N)
    */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root != null) {
            TreeNode head = new TreeNode(0, null, root);
            Stack<TreeNode> stk = new Stack<>();
            stk.push(head);

            while (!stk.isEmpty()) {
                head = stk.pop().right;
                while (head != null) {
                    ans.add(head.val);
                    stk.push(head);
                    head = head.left;
                }
            }
        }
        return ans;
    }
}
