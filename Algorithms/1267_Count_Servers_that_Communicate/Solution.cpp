#include <cstdio>
#include <vector>
using namespace std;

class Solution {
    public:
        int countServers(vector<vector<int>>& grid) {
            int m = grid.size(), n = grid[0].size(), total_servers = 0;

            int row_servers[m] = {0};
            int col_servers[n] = {0};

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j]) {
                        total_servers++;
                        row_servers[i]++;
                        col_servers[j]++;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] && row_servers[i] == 1 && col_servers[j] == 1) {
                        total_servers--;
                    }
                }
            }

            return total_servers;
        }
};
