class Solution {

    /*
    Approach:
      - 0과 1이 연속으로 나타나는 개수를 카운트
        ex) 0110001111 -> 1, 2, 3, 4 (0이 1개, 1이 2개, 0이 3개, 1이 4개)
      - 인접한 두 수가 연속이 아닐 때 만들수 있는 binarySubstring 은 min(이전, 지금)
        ex) 0001111 일 때, min(3, 4) = 3이고, 만들수 있는 binarySubstring은 01, 0011, 000111으로 3개
    Time Complexity: O(N)
    Space Complexity: O(1)
    */
    public int countBinarySubstrings(String s) {
        int prevLen = 0, curLen = 1, count = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                ++curLen;
            } else {
                count += Math.min(prevLen, curLen);
                prevLen = curLen;
                curLen = 1;
            }
        }
        return count + Math.min(prevLen, curLen);
    }
}
