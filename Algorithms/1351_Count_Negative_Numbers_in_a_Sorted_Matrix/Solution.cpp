#include <cstdio>
#include <vector>
using namespace std;

class Solution {
public:
  int countNegatives(vector<vector<int>>& grid) {
    int c = 0, m = grid.size(), n = grid[0].size();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] < 0) {
          c += n - j;
          break;
        }
      }
    }
    return c;
  }
};
