import java.util.*;

class Solution {
    /*
    Approach: 문자열을 처음부터 끝까지 훑으면서 인덱스를 스택에 push. 만약 올바른 괄호가 만들어지면 스택에서 pop
    위 과정을 거치고 나면 스택엔 invalid 한 문자들의 인덱스만 남게됨.
    이 때 인덱스들의 양 옆끼리 비교한 값이 최대로 만들 수 있는 valid 괄호 substring의 길이이며, 이 최대값을 구해서 리턴하면 됨

    Time Complexity: O(N)
    Space Complexity: O(N)
    */
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (!stk.isEmpty() && s.charAt(stk.peek()) == '(' && s.charAt(i) == ')') {
                stk.pop();
            } else {
                stk.push(i);
            }
        }

        int maxLen = 0;
        int[] mis = new int[stk.size() + 2];
        mis[0] = -1;
        mis[mis.length - 1] = s.length();
        for (int i = mis.length - 2; i > 0; --i) {
            mis[i] = stk.pop();
            maxLen = Math.max(maxLen, mis[i + 1] - mis[i] - 1);
        }
        return Math.max(maxLen, mis[1] - mis[0] - 1);
    }
}
