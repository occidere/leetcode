import java.util.Deque;
import java.util.LinkedList;

/*
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int idx = 0;

    public Node expTree(String s) {
        Deque<Node> dq = new LinkedList<>();
        Node cur = new Node(s.charAt(idx++));
        dq.addLast(cur.val == '(' ? expTree(s) : cur);

        while (idx < s.length()) {
            cur = new Node(s.charAt(idx++));
            if (isNumber(cur)) {
                dq.addLast(mulDivAtLast(dq) ? makeTree(dq, cur) : cur);
            } else if (cur.val == '(') {
                dq.addLast(mulDivAtLast(dq) ? makeTree(dq, expTree(s)) : expTree(s));
            } else if (cur.val == ')') {
                break;
            } else {
                dq.addLast(cur); // +, -
            }
        }

        while (dq.size() > 1) {
            Node left = dq.poll();
            Node root = dq.poll();
            root.left = left;
            root.right = dq.poll();
            dq.addFirst(root);
        }
        return dq.poll();
    }

    private boolean isNumber(Node node) {
        return '0' <= node.val && node.val <= '9';
    }

    private boolean mulDivAtLast(Deque<Node> dq) {
        return dq.getLast().val == '*' || dq.getLast().val == '/';
    }

    private Node makeTree(Deque<Node> dq, Node right) {
        Node root = dq.pollLast();
        root.left = dq.pollLast();
        root.right = right;
        return root;
    }
}