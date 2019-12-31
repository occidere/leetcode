#include <cstdio>
#include <vector>
#include <cmath>
using namespace std;

class Solution {
public:
    int maxIncreaseKeepingSkyline(vector<vector<int>>& grid) {
        int v = grid.size(), h = grid[0].size(), inc = 0;
        int v_max[v] = {0}, h_max[h] = {0};

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < h; j++) {
                v_max[i] = max(v_max[i], grid[i][j]);
                h_max[j] = max(h_max[j], grid[i][j]);
            }
        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < h; j++) {
                inc += min(v_max[i], h_max[j]) - grid[i][j];
            }
        }

        return inc;
    }
};
