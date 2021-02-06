#include <cstdio>
#include <vector>
#include <utility>
using namespace std;


class Solution {
public:
    vector<vector<int>> candyCrush(vector<vector<int>>& board) {
    m = board.size();
    n = board[0].size();

    bool crushed;
    do {
        crushed = false;
        vector<vector<pair<int, int>>> candidates;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] != 0) {
                    find_breakable(board, i, j, candidates);
                }
            }
        }

        if (!candidates.empty()) {
            crushed = true;
            crush(board, candidates);
        }

        if (crushed) {
            push_down(board);
        }
    } while (crushed);

    return board;
}

private:
    int m, n, dx[4] = {-1, 1, 0, 0}, dy[4] = {0, 0, -1, 1};

    bool in_range(int x, int y) {
        return (0 <= x && x < m) && (0 <= y && y < n);
    }

    void find_breakable(vector<vector<int>>& board, int x, int y, vector<vector<pair<int, int>>>& candidates) {
        int candy = board[x][y];
        for (int i = 0; i < 4; ++i) {
            int ax = x + dx[i], ay = y + dy[i];
            vector<pair<int, int>> candies = {make_pair(x, y)};

            while (in_range(ax, ay) && board[ax][ay] == candy) {
                candies.push_back(make_pair(ax, ay));
                ax += dx[i];
                ay += dy[i];
            }

            if (candies.size() >= 3) {
                candidates.push_back(candies);
            }
        }
    }

    void crush(vector<vector<int>>& board, vector<vector<pair<int, int>>>& candidates) {
        for (vector<pair<int, int>> candidate : candidates) {
            for (pair<int, int> candy : candidate) {
                board[candy.first][candy.second] = 0;
            }
        }
    }

    void push_down(vector<vector<int>>& board) {
        for (int i = 0; i < n; ++i) {
            vector<int> non_zero;
            for (int j = m - 1; j >= 0; --j) {
                if (board[j][i] != 0) {
                    non_zero.push_back(board[j][i]);
                }
                board[j][i] = 0;
            }
            for (int j = 0; j < non_zero.size(); ++j) {
                board[m - j - 1][i] = non_zero[j];
            }
        }
    }
};
