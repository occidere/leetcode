#include <cstdio>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int heightChecker(vector<int>& heights) {
        vector<int> sorted(heights);
        sort(sorted.begin(), sorted.end());

        int count = 0;
        for (int i = 0; i < sorted.size(); i++) {
            count += heights[i] != sorted[i];
        }

        return count;
    }
};
