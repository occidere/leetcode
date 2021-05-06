import java.util.*;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
//     public Node lowestCommonAncestor(Node p, Node q) {
//         Stack<Node> pStk = traversal(p), qStk = traversal(q);
//         Node common = pStk.pop();
//         qStk.pop();
//         while (!pStk.isEmpty() && !qStk.isEmpty() && pStk.peek().val == qStk.peek().val) {
//             common = pStk.pop();
//             qStk.pop();
//         }
//         return common;
//     }

//     private Stack<Node> traversal(Node node) {
//         Stack<Node> stk = new Stack<>();
//         while (node != null) {
//             stk.push(node);
//             node = node.parent;
//         }
//         return stk;
//     }

    // https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!/165648
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p, b = q;
        while (a != b) {
            a = a == null ? q : a.parent;
            b = b == null ? p : b.parent;
        }
        return a;
    }
}
