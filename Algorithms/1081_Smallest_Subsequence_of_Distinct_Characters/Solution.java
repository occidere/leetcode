import java.util.*;

class Solution {

    /*
    Approach: 앞에서부터 문자들을 하나씩 채워나가면서, 조건을 매번 충족시키도록 변형함
    만약 현재 문자가 이미 등장했다면 스킵, 등장한 적이 없다면 아래 조건에 해당하는 놈들은 조건 충족을 방해하는 놈들이기 때문에 제거
    - 지금 문자보다 큰 문자이면서, 현재 위치보다 뒤에 또 등장할 예정인 경우
    - ex) stk = [ a, c ], 현재 문자가 b 이고, 현재 문자열 s 기준 위치는 2일 때, stk에 담긴 c 가 나중에 위치 5에서 또 등장한다면? => 삭제

    Time Complexity: O(N)
    Space Complexity: O(N)
    */
    public String smallestSubsequence(String s) {
        Map<Character, Integer> lastPos = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            lastPos.put(s.charAt(i), i);
        }

        Set<Character> used = new HashSet<>();
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (!used.contains(c)) {
                while (!stk.isEmpty() && c < stk.peek() && i < lastPos.get(stk.peek())) {
                    used.remove(stk.pop());
                }
                stk.push(c);
                used.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}
