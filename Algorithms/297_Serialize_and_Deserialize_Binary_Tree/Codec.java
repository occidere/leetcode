import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private Iterator<String> it;
    private List<String> trace;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        trace = new ArrayList<>();
        postOrder(root);
        return String.join(" ", trace);
    }

    // Decodes your encoded data to tree. 
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        if (data != null && data.length() > 0) {
            String[] nodes = data.split(" ", -1);
            root = new TreeNode(Integer.parseInt(nodes[0].split("_", -1)[1]));
            it = Arrays.stream(nodes).iterator();
            build(root);
        }
        return root;
    }

    private void build(TreeNode root) {
        if (root != null) {
            String[] n = it.next().split("_", -1);
            root.left = n[0].length() > 0 ? new TreeNode(Integer.parseInt(n[0])) : null;
            root.right = n[2].length() > 0 ? new TreeNode(Integer.parseInt(n[2])) : null;
            build(root.left);
            build(root.right);
        }
    }

    private void postOrder(TreeNode root) {
        if (root != null) {
            trace.add(getVal(root.left) + "_" + root.val + "_" + getVal(root.right));
            postOrder(root.left);
            postOrder(root.right);
        }
    }

    private static String getVal(TreeNode node) {
        return "" + (node == null ? "" : node.val);
    }
}