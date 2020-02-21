#include <cstdio>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> grayCode(int n) {
        vector<int> gray = vector<int>({0});
        for (int i = 0; i < n; ++i) {
            for (int j = gray.size(); j > 0; --j) {
                gray.push_back((gray[j - 1] | 1 << i));
            }
        }
        return gray;
    }
};
