import java.util.*;

class Solution {
    /*
    Approach: 현재 수가 2^n ~ 2^n+1 사이에 속하는지 n 을 구하고, 뒤집어야 하는 위치에 존재하는 경우 값을 뒤집어줌.
    이후 /2 해서 parent 로 올라가서 반복

    Time Complexity: O(logN)
    Space Complexity: O(logN)
    */
    public List<Integer> pathInZigZagTree(int label) {
        int n = -1;
        for (int i = 1; i <= label; i <<= 1, ++n);

        int[] path = new int[n + 1];
        int mod = (n + 1) % 2, node = label;
        for (; n >= 0; --n, node >>= 1) {
            path[n] = n % 2 == mod ? ((int) Math.pow(2, n + 1)) - 1 - node + ((int) Math.pow(2, n)) : node;
        }
        path[path.length - 1] = label;

        List<Integer> ans = new ArrayList<>();
        for (int p : path) {
            ans.add(p);
        }
        return ans;
    }
}
