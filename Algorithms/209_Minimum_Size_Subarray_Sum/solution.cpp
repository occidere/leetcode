#include <cstdio>
#include <vector>
#include <cmath>
using namespace std;

class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int i = 0, j = 1, n = nums.size();
        int acc = nums[0], min_len = 0x3f3f3f3f;
        while (i < n && j <= n) {
            if (acc < target) {
                if (j < n) {
                    acc += nums[j++];
                } else {
                    break;
                }
            } else {
                min_len = min(min_len, j - i);
                acc -= nums[i++];
            }
        }
        return min_len == 0x3f3f3f3f ? 0 : min_len;
    }
};
