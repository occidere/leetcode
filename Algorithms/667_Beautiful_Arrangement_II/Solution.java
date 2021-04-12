import java.util.*;

class Solution {

    /*
    Approach: First, we'll create array wigglely likes [1, 6, 2, 5, 3, 4]
    If we want to make difference exactly k elements, we should get n - k - 1 elements in ascending order.
    For example, in [1, 2, 3, 4, 5, 6], if k = 3, then we fetch 6 - 3 - 1 (= 2) elements. It's [1, 2, , , , ]
    And then, fetch elements wigglely small one and large one repeateadly.
    [1, 2, 3, , , ]
    [1, 2, 3, 6, , ]
    [1, 2, 3, 6, 4, ]
    [1, 2, 3, 6, 4, 5]

    diff = [1, 1, 3, 2, 1], k = 3
    
    Time Complexity: O(N)
    Space Complexity: O(N)
    */
    public int[] constructArray(int n, int k) {
        int small = 1, large = n, ansIdx = 0;
        int[] ans = new int[n];

        // insert smallest first only n - k - 1 times.
        for (int i = n - k - 1; i > 0; --i) {
            ans[ansIdx++] = small++;
        }

        // insert small and large repeateadly
        while (ansIdx < n) {
            ans[ansIdx++] = small++;
            if (ansIdx < n - 1) {
                ans[ansIdx++] = large--;
            }
        }
        return ans;
    }
}

/*
Examples:

1, 2, 3, 4, 5 => 1, 1, 1, 1
1, 5, 2, 4, 3 => 4, 3, 2, 1 (4)
1, 2, 5, 3, 4 => 1, 3, 2, 1 (3)
1, 2, 3, 5, 4 => 1, 1, 2, 1 (2)
1, 2, 3, 4, 5 => 1, 1, 1, 1 (1)

1, 2, 3, 4, 5, 6 => 1, 1, 1, 1, 1 (1)
1, 6, 2, 5, 3, 4 => 5, 4, 3, 2, 1 (5)
1, 2, 6, 3, 5, 4 => 1, 4, 3, 2, 1 (4)
1, 2, 3, 6, 4, 5 => 1, 1, 3, 2, 1 (3)
1, 2, 3, 4, 6, 5 => 1, 1, 1, 2, 1 (2)
*/
