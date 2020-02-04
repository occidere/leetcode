#include <cstdio>
#include <algorithm>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        int n = mat.size(), m = mat[0].size();
        vector<vector<int>> ans = vector<vector<int>>(n);
        for (int i = 0; i < n; i++) {
            ans[i] = vector<int>(m);
        }

        for (int i = 0; i < m; i++) {
            vector<int> tmp;
            int x = 0, y = i;
            while (x < n && y < m) {
                tmp.push_back(mat[x++][y++]);
            }
            sort(tmp.begin(), tmp.end());
            x = 0; y = i;
            for (int k : tmp) {
                ans[x++][y++] = k;
            }
        }

        for (int i = 1; i < n; i++) {
            vector<int> tmp;
            int x = i, y = 0;
            while (x < n && y < m) {
                tmp.push_back(mat[x++][y++]);
            }
            sort(tmp.begin(), tmp.end());
            x = i; y = 0;
            for (int k : tmp) {
                ans[x++][y++] = k;
            }
        }

        return ans;
    }
};
