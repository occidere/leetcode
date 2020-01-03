#include <cstdio>
#include <vector>
using namespace std;

class Solution {
public:
    int peakIndexInMountainArray(vector<int>& A) {
        int peek = -1;
        for (int i = 1; i < A.size(); i++) {
            if (A[i - 1] > A[i]) {
                peek = i - 1;
                break;
            }
        }
        return peek;
    }
};
