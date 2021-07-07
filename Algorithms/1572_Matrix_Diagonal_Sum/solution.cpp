#include <vector>
using namespace std;

class Solution {
    public:
        int diagonalSum(vector<vector<int>>& mat) {
            int n = mat.size(), acc = 0, i = 0, j = 0;
            while (i < n && j < n) {
                acc += mat[i++][j++];
            }

            j = 0;
            while (i > 0 && j < n) {
                acc += mat[--i][j++];
            }

            return acc - (n % 2 ? mat[n / 2][n / 2] : 0);
        }
};
