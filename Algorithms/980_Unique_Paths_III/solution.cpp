#include <cstdio>
#include <vector>
#include <cmath>
using namespace std;

class Solution {
public:
    int uniquePathsIII(vector<vector<int>>& grid) {
        m = grid.size();
        n = grid[0].size();

		int x, y;
        for (int i = 0; i < m; ++i) {
        	visit[i] = 0;
        	for (int j = 0; j < n; ++j) {
        		if (grid[i][j] == -1) {
					visit[i] |= (1 << j);
				} else if (grid[i][j] == 1) {
        			x = i;
        			y = j;
				} 
			}
		}

		all_visited = ((int) pow(2, n)) - 1;
		visit[x] |= (1 << y);
		dfs(grid, x, y);

        return count;
    }

private:
	int m, n, all_visited, count = 0;
	int dx[4] = {-1, 1, 0, 0}, dy[4] = {0, 0, -1, 1}, visit[20] = {0};

	void dfs(vector<vector<int>> &grid, int x, int y) {
		if (grid[x][y] == 2 && visit_all()) {
			++count;
			return;
		}

		for (int i = 0; i < 4; ++i) {
			int ax = x + dx[i], ay = y + dy[i];
			if (in_range(ax, ay) && grid[ax][ay] != -1 && (visit[ax] & (1 << ay)) == 0) {
				visit[ax] |= (1 << ay);
				dfs(grid, ax, ay);
				visit[ax] ^= (1 << ay);
			}
		}
	}

	bool in_range(int x, int y) {
		return (0 <= x && x < m) && (0 <= y && y < n);
	}

	bool visit_all() {
		for (int i = 0; i < m; ++i) {
			if ((visit[i] & all_visited) != all_visited) {
				return false;
			}
		}
		return true;
	}
};
