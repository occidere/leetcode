#include <cstdio>
#include <vector>
using namespace std;

class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        int n_sum = ((1 + N) * N) >> 1;
        int voted[1001] = {0}, poplr_dgr[1001] = {0};

        for (vector<int> v : trust) {
            if (!voted[v[0]]) {
                n_sum -= v[0];
                voted[v[0]] = 1;
            }
            ++poplr_dgr[v[1]];
        }

        return poplr_dgr[n_sum] == N - 1 ? n_sum : -1;
    }
};
