import java.util.*;

class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> powerful = new HashSet<>();
        int[] dx = new int[101], dy = new int[101];

        for (int i = 0; ; ++i) {
            dx[i] = (int) Math.pow(x, i);
            if (dx[i] > bound) {
                break;
            }
            for (int j = 0; ; ++j) {
                if (dy[j] == 0) {
                    dy[j] = (int) Math.pow(y, j);
                }
                if (dx[i] + dy[j] > bound) {
                    break;
                }
                powerful.add(dx[i] + dy[j]);
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }
        }

        return new ArrayList<>(powerful);
    }
}
