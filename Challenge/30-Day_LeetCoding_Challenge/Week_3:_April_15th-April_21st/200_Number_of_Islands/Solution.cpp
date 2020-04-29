#include <cstdio>
#include <vector>
using namespace std;

class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        m = grid.size();
        n = m > 0 ? grid[0].size() : 0;

        int number_of_island = 0;
        for (int i = 0; i < grid.size(); ++i) {
            for (int j = 0; j < grid[0].size(); ++j) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    ++number_of_island;
                    flood_fill(grid, i, j);
                }
            }
        }

        return number_of_island;
    }

private:
    int m, n;
    int dx[4] = {-1, 1, 0, 0}, dy[4] = {0, 0, -1, 1};

    bool in_range(int x, int y) {
        return (0 <= x && x < m) && (0 <= y && y < n);
    }

    void flood_fill(vector<vector<char>>& grid, int x, int y) {
        for (int i = 0; i < 4; ++i) {
            int ax = x + dx[i], ay = y + dy[i];
            if (in_range(ax, ay) && grid[ax][ay] == '1') {
                grid[ax][ay] = '0';
                flood_fill(grid, ax, ay);
            }
        }
    }
};
