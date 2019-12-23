#include <cstdio>
#include <vector>
#include <string>
using namespace std;

class Solution {
    public:
        int findNumbers(vector<int>& nums) {
            int count = 0;

            for (int i = 0; i < nums.size(); i++) {
                if (to_string(nums[i]).length() % 2 == 0) {
                    count++;
                }
            }

            return count;
        }
};
