#include <cstdio>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        map<int, int> pos;
        for (int i = 0; i < nums2.size(); i++) {
            pos.insert(make_pair(nums2[i], i));
        }

        vector<int> ans;
        for (int i = 0; i < nums1.size(); i++) {
            int n = -1;
            for (int j = pos[nums1[i]]; j < nums2.size(); j++) {
                if (nums1[i] < nums2[j]) {
                    n = nums2[j];
                    break;
                }
            }
            ans.push_back(n);
        }

        return ans;
    }
};
