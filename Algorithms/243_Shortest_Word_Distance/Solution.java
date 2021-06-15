import java.util.*;

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        for (int i = 0; i < wordsDict.length; ++i) {
            if (wordsDict[i].equals(word1)) {
                q1.add(i);
            } else if (wordsDict[i].equals(word2)) {
                q2.add(i);
            }
        }

        int minDist = 0x3f3f3f3f;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int p1 = q1.peek(), p2 = q2.peek();
            minDist = Math.min(minDist, Math.abs(p1 - p2));
            if (p1 < p2) {
                q1.poll();
            } else {
                q2.poll();
            }
        }
        return minDist;
    }
}
