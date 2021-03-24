import java.util.*;

/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    private final Map<Node, NodeCopy> caches = new HashMap<>();

    /*
    Approach: Recursion with Map cache

    Time Complexity: O(N). Traversal whole tree once.
    Space Complexity: O(N). Caching tree's elements.
    */
    public NodeCopy copyRandomBinaryTree(Node root) {
        if (root == null) {
            return null;
        } else if (caches.containsKey(root)) {
            return caches.get(root);
        }

        NodeCopy copied = new NodeCopy(root.val);
        caches.put(root, copied);

        copied.left = copyRandomBinaryTree(root.left);
        caches.put(root.left, copied.left);

        copied.right = copyRandomBinaryTree(root.right);
        caches.put(root.right, copied.right);

        copied.random = copyRandomBinaryTree(root.random);
        caches.put(root.random, copied.random);

        return copied;
    }
}
