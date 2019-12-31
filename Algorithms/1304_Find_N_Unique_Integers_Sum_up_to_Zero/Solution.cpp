#include <cstdio>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> sumZero(int n) {
        vector<int> ans;

        for (int i = 1; i < n; i += 2) {
            ans.push_back(i);
            ans.push_back(-i);
        }

        if (n % 2) {
            ans.push_back(0);
        }

        return ans;
    }
};
