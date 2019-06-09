#include <cstdio>
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution
{
public:
    vector<vector<int>> threeSum(vector<int> &nums)
    {
        sort(nums.begin(), nums.end());

        vector<vector<int>> res;
        int len = nums.size();
        for (int i = 0; i < len - 2; i++)
        {
            if (i > 0 && nums[i] == nums[i - 1])
            {
                continue;
            }
            for (int l = i + 1, r = len - 1; l < r;)
            {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0)
                {
                    res.push_back({nums[i], nums[l], nums[r]});
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1])
                    {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1])
                    {
                        r--;
                    }
                }
                else if (sum > 0)
                {
                    r--;
                }
                else
                {
                    l++;
                }
            }
        }

        return res;
    }
};
