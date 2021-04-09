class Solution {
    /*
    Approach: 아래 계산을 반복 수행
    - top (-), cur (-) or top (+), cur (+) or top (-), cur (+) => push
    - top (+) > cur (-) => remove cur
    - top (+) < cur (-) => remove top
    - top (+) = cur (-) => remove both

    Time Complexity: O(N)
    Space Complexity: O(N)
    */
    public int[] asteroidCollision(int[] asteroids) {
        int i = 0, size = 0;
        int[] stk = new int[asteroids.length];
        while (i < asteroids.length) {
            int cur = asteroids[i];
            if (size == 0 || stk[size - 1] * cur > 0 || stk[size - 1] < cur) {
                stk[size++] = cur;
                ++i;
            } else if (stk[size - 1] > -cur) {
                ++i;
            } else if (stk[size - 1] < -cur) {
                --size;
            } else {
                --size;
                ++i;
            }
        }

        int[] rest = new int[size];
        for (i = rest.length - 1; i >= 0; --i) {
            rest[i] = stk[--size];
        }
        return rest;
    }
}
