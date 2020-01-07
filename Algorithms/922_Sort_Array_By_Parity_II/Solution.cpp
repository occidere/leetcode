#include <cstdio>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> sortArrayByParityII(vector<int>& A) {
        int i = 0, j = 1, n = A.size();
        vector<int> ans(n);

        for (int& a : A) {
            if (a % 2) {
                ans[j] = a;
                j += 2;
            } else {
                ans[i] = a;
                i += 2;
            }
        }

        return ans;
    }
};
