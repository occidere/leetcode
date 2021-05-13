import java.util.*;

class Solution {

    /*
    Approach: 왼쪽, 오른쪽으로 나눈 뒤 각각의 숫자를 그 자신과 소수점을 붙였을 때 올바르게 되는 경우를 생성. 이후 카타시안 곱으로 조합 생성

    Time Complexity: O(N^3)
    Space Complexity: O(N^3)
    */
    public List<String> ambiguousCoordinates(String s) {
        s = s.substring(1, s.length() - 1);
        List<String> coords = new ArrayList<>();
        for (int i = 1; i < s.length(); ++i) {
            List<String> lefts = createValidData(s.substring(0, i));
            List<String> rights = createValidData(s.substring(i));
            for (String left : lefts) {
                for (String right: rights) {
                    coords.add("(" + left + ", " + right + ")");
                }
            }
        }
        return coords;
    }

    private List<String> createValidData(String s) {
        int len = s.length();
        List<String> data = new ArrayList<>();
        if (s.charAt(0) == '0' && s.charAt(len - 1) == '0') {
            if (len == 1) {
                data.add(s);
            }
        } else if (s.charAt(0) == '0') { // 0.xxxx 만 valid
            data.add("0." + s.substring(1));
        } else if (s.charAt(len - 1) == '0') { // xxxxx0 만 valid
            data.add(s); 
        } else {
            data.add(s);
            for (int i = 1; i < len; ++i) {
                data.add(s.substring(0, i) + "." + s.substring(i));
            }
        }
        return data;
    }
}
