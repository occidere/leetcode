#include <cstdio>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        n = board.size();
        m = board[0].size();

        visit = vector<vector<bool>>(n);
        fill(visit.begin(), visit.end(), vector<bool>(m));

        for (int i = 0; !find && i < n; i++) {
            for (int j = 0; !find && j < m; j++) {
                visit[i][j] = true;
                dfs(board, i, j, string(1, board[i][j]), word);
                visit[i][j] = false;
            }
        }

        return find;
    }

private:
    bool find = false;
    vector<vector<bool>> visit;
    int n, m, dx[4] = {-1, 1, 0, 0}, dy[4] = {0, 0, -1, 1};

    bool in_range(int x, int y) {
        return (0 <= x && x < n) && (0 <= y && y < m);
    }

    void dfs(vector<vector<char>>& board, int x, int y, string s, string word) {
        if (word.substr(0, s.size()) != s) {
            return;
        } else if (find || s == word) {
            find = true;
            return;
        }

        for (int i = 0; !find && i < 4; i++) {
            int ax = x + dx[i], ay = y + dy[i];
            if (in_range(ax, ay) && !visit[ax][ay]) {
                visit[ax][ay] = true;
                dfs(board, ax, ay, s + board[ax][ay], word);
                visit[ax][ay] = false;
            }
        }
    }
};
