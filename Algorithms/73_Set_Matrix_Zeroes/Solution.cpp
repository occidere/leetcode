#include <cstdio>
#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        m = matrix.size();
        n = matrix[0].size();
        for (int i = 0; i < m * n; i++) {
            v.push_back('0');
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (v[n * i + j] == '0' && !matrix[i][j]) {
                    flood(matrix, i, j);
                }
            }
        }
    }

private:
    int m, n;
    string v;

    bool visit(vector<vector<int>>& matrix, int i, int j) {
        if (!(0 <= i && i < m) || !(0 <= j && j < n)) {
            return false;
        } else if (matrix[i][j]) {
            v[n * i + j] = '1';
            matrix[i][j] = 0;
        }
        return true;
    }

    void flood(vector<vector<int>>& matrix, int x, int y) {
        for (int i = x, j = y; visit(matrix, i, j); i--); // up
        for (int i = x, j = y; visit(matrix, i, j); i++); // down
        for (int i = x, j = y; visit(matrix, i, j); j--); // left
        for (int i = x, j = y; visit(matrix, i, j); j++); // right
    }
};
