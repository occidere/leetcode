import java.util.*;

/*
Approach: Java의 BinarySearch가 목표를 못 찾으면 삽입해야 할 구간의 음수값을 반환하는 것을 이용하여 dp 배열에 LIS를 채워나감
ex)
target = 0   1   2   3   4   5   6
array  =     1       3       5
return = -1  0  -2   1  -3   2  -4

결과적으로 가장 작은 수일 수록 dp 배열의 앞에 위치하며, 뒤로 갈수록 점점 수가 커지는 LIS 가 만들어짐

Time Complexity: O(NlogN). BinarySearch가 O(logN) * 배열 전체에 대해서 O(N)
Space Complexity: O(N)
*/
public class Solution {
    public int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int n : nums) {
            int i = Arrays.binarySearch(dp, 0, len, n); 
            if(i < 0) i = -(i + 1);
            dp[i] = n;
            if(i == len) len++;
        }

        return len;
    }
}
