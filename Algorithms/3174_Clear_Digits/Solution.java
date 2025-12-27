import java.util.Stack;
import java.util.stream.Collectors;

class Solution {
    public String clearDigits(String s) {
        var stk = new Stack<Character>();
        for (var c : s.toCharArray()) {
            if (Character.isDigit(c) && !stk.isEmpty() && !Character.isDigit(stk.peek())) {
                stk.pop();
                continue;
            }
            stk.push(c);
        }
        return stk.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
