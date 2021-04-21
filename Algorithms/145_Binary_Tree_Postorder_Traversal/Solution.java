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
    Approach: preorder를 interative 하게 순회하는 것을 응용. right 부터 진행하는 preorder의 결과를 reverse하면 postorder 가 됨

    Time Complexity: O(N)
    Space Complexity: O(N)
    */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (root != null) {
            TreeNode head = new TreeNode(0, root, null);
            Stack<TreeNode> stk = new Stack<>();
            stk.push(head);

            while (!stk.isEmpty()) {
                head = stk.pop().left;
                while (head != null) {
                    ans.addFirst(head.val);
                    stk.push(head);
                    head = head.right;
                }
            }
        }
        return ans;
    }
}
