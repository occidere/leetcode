#include <cstdio>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> decompressRLElist(vector<int>& nums) {
        vector<int> ans;
        for (int i = 1; i < nums.size(); i += 2) {
            for (int j = 0; j < nums[i - 1]; j++) {
                ans.push_back(nums[i]);
            }
        }
        return ans;
    }
};
