#include <cstdio>
#include <vector>
#include <cmath>
#include <queue>
#include <utility>
using namespace std;

class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        m = heights.size();
        n = heights[0].size();

        int min_cost = 1000000;
        int left = 0, right = 1000000;

        while (left <= right) {
            int mid = (left + right) >> 1;
            if (has_path(heights, mid)) {
                min_cost = min(min_cost, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return min_cost;
    }

private:
    int m, n, dx[4] = {-1, 1, 0, 0}, dy[4] = {0, 0, -1, 1};

    bool in_range(int x, int y) {
        return (0 <= x && x < m) && (0 <= y && y < n);
    }

    bool has_path(vector<vector<int>>& heights, int max_cost) {
        bool visit[101][101] = {false};
        visit[0][0] = true;

        queue<pair<int, int>> q;
        q.push(make_pair(0, 0));

        while (!q.empty()) {
            pair<int, int> cur = q.front();
            q.pop();
            int x = cur.first, y = cur.second;

            if (x == m - 1 && y == n - 1) {
                return true;
            }

            for (int i = 0; i < 4; ++i) {
                int ax = x + dx[i], ay = y + dy[i];
                if (in_range(ax, ay) && !visit[ax][ay]) {
                    if ((int) abs(heights[ax][ay] - heights[x][y]) <= max_cost) {
                        visit[ax][ay] = true;
                        q.push(make_pair(ax, ay));
                    }
                }
            }
        }

        return false;
    }
};
