#include <cstdio>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> flipAndInvertImage(vector<vector<int>>& A) {
        int n = A.size(), m = A[0].size();
        for (int i = 0; i < n; i++) {
            vector<int> tmp(m);
            for (int j = 0; j < m; j++) {
                tmp[m - j - 1] = (A[i][j] + 1) % 2;
            }
            A[i] = tmp;
        }
        return A;
    }
};
