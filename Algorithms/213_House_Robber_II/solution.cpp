#include <cstdio>
#include <vector>
#include <cmath>
using namespace std;

class Solution {
public:
    int rob(vector<int>& nums) {
    	if (nums.size() == 1) {
    		return nums[0];
		}
		vector<int> remove_first(nums.begin() + 1, nums.end());
		vector<int> remove_last(nums.begin(), nums.end() - 1);
	    return max(try_rob(remove_first), try_rob(remove_last));
    }

private:
	int try_rob(vector<int>& nums) {
        int n = nums.size();
		int max_money = 0, before_one = 0, before_two = 0;
		for (int i = 0; i < n; ++i) {
			max_money = max(before_two + nums[i], before_one);
			before_two = before_one;
			before_one = max_money;
		}
		return max_money;
	}
};
