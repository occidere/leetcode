#include <cstdio>
#include <vector>
using namespace std;

class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        v = grid.size();
        h = grid[0].size();

        int sum = 0;
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < h; j++) {
                sum += get_perimeter(grid, i, j);
            }
        }

        return sum;
    }

private:
    int v, h;
    int dx[4] = {-1, 1, 0, 0}, dy[4] = {0, 0, -1, 1};

    int get_perimeter(vector<vector<int>>& grid, int x, int y) {
        int p = 0;
        if (grid[x][y]) {
            p = 4;
            for (int i = 0; i < 4; i++) {
                int ax = x + dx[i], ay = y + dy[i];
                if ((0 <= ax && ax < v) && (0 <= ay && ay < h)) {
                    p -= grid[ax][ay];
                }
            }
        }
        return p;
    }
};
