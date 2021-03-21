import java.util.*;

/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();

    // define your fields here
    public String val;
    public Node left, right;
};

class PlusNode extends Node {
    public PlusNode(Node left, Node right) {
        super.left = left;
        super.right = right;
    }

    @Override
    public int evaluate() {
        return left.evaluate() + right.evaluate();
    }
}

class MinusNode extends Node {
    public MinusNode(Node left, Node right) {
        super.left = left;
        super.right = right;
    }

    @Override
    public int evaluate() {
        return left.evaluate() - right.evaluate();
    }
}

class MultiplyNode extends Node {
    public MultiplyNode(Node left, Node right) {
        super.left = left;
        super.right = right;
    }

    @Override
    public int evaluate() {
        return left.evaluate() * right.evaluate();
    }
}

class DivideNode extends Node {
    public DivideNode(Node left, Node right) {
        super.left = left;
        super.right = right;
    }

    @Override
    public int evaluate() {
        return left.evaluate() / right.evaluate();
    }
}

class NumberNode extends Node {
    public NumberNode(String val) {
        super.val = val;
    }

    @Override
    public int evaluate() {
        return Integer.parseInt(val);
    }
}


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */
class TreeBuilder {

    Node buildTree(String[] postfix) {
        Stack<Node> stk = new Stack<>();
        for (String s : postfix) {
            stk.push(getNode(stk, s));
        }
        return stk.pop();
    }

    private static final Set<String> ops = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    private static Node getNode(Stack<Node> stk, String s) {
        if (ops.contains(s)) {
            Node right = stk.pop(), left = stk.pop();
            switch (s) {
                case "+":
                    return new PlusNode(left, right);
                case "-":
                    return new MinusNode(left, right);
                case "*":
                    return new MultiplyNode(left, right);
                case "/":
                    return new DivideNode(left, right);
            }
        }
        return new NumberNode(s);
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
