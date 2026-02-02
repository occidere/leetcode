import java.util.*;

class Solution {
    public String reverseByType(String s) {
        Queue<Integer> ltrQ = new LinkedList<>();
        Queue<Integer> spcQ = new LinkedList<>();
        for (int i = 0; i < s.length(); ++i) {
            if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                ltrQ.offer(i);
            } else {
                spcQ.offer(i);
            }
        }
        char[] chs = new char[s.length()];
        for (int i = s.length() - 1; i >= 0; --i) {
            char c = s.charAt(i);
            if ('a' <= c && c <= 'z') {
                chs[ltrQ.poll()] = c;
            } else {
                chs[spcQ.poll()] = c;
            }
        }
        return new String(chs);
    }
}
