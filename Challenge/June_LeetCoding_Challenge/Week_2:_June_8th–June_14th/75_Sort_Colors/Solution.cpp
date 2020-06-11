#include <cstdio>
#include <vector>
using namespace std;

class Solution {
public:
    void sortColors(vector<int>& nums) {
        // Algorithm of Dutch National Flag Problem by Dijkstra
        // ref: https://en.wikipedia.org/wiki/Dutch_national_flag_problem
        int top_of_underclass = 0;
        int top_of_middleclass = 0;
        int bottom_of_highclass = nums.size();
        int mid = 1;

        while (top_of_middleclass < bottom_of_highclass) {
            if (nums[top_of_middleclass] < mid) {
                swap(nums, top_of_underclass++, top_of_middleclass++);
            } else if (nums[top_of_middleclass] > mid) {
                swap(nums, top_of_middleclass, --bottom_of_highclass);
            } else {
                ++top_of_middleclass;
            }
        }
    }

private:
    void swap(vector<int>& nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
};
