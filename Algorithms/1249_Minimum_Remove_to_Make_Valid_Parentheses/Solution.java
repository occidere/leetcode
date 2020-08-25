import java.util.Stack;

public class Solution {
    public String minRemoveToMakeValid(String s) {
        String[] cs = s.split("");
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < cs.length; i++) {
            if ("(".equals(cs[i])) {
                stk.push(i);
            } else if (")".equals(cs[i])) {
                if (stk.isEmpty()) {
                    cs[i] = "";
                } else {
                    stk.pop();
                }
            }
        }
        while (!stk.isEmpty()) {
            cs[stk.pop()] = "";
        }
        return String.join("", cs);
    }
}