import java.util.*;

class Solution {

    /*
    Approach: a, b, c, d 일 때 a < b > c < d 인 경우 b 값을 낮추거나 c 값을 높이는걸 1번만 할 수 있는지 판단.

    Time Complexity: O(N)
    Space Complexity: O(N)
    */
    public boolean checkPossibility(int[] nums) {
        int[] arr = new int[nums.length + 2];
        arr[0] = -0x3f3f3f3f;
        arr[arr.length - 1] = 0x3f3f3f3f;
        for (int i = 0; i < nums.length; ++i) {
            arr[i + 1] = nums[i];
        }

        int count = 0, skip = 0;
        for (int i = 1; i < arr.length - 1; ++i) {
            int prev = arr[i - 1], cur = arr[i], next = arr[i + 1];
            if (prev <= cur && cur <= next) {
                continue;
            } else if ((cur > next && prev <= next) || (prev > cur && cur <= next)) {
                arr[i] = i == 1 ? next : prev;
                ++count;
                skip = 0;
            } else {
                ++skip;
            }

            if (count >= 2 || skip >= 2) {
                return false;
            }
        }

        return true;
    }
}
