#include <cstdio>
using namespace std;

class Solution {
public:
    int numberOfSteps (int num) {
        int c;
        for (c = 0; num; c += (num & 1) ? 2 : 1, num >>= 1);
        return c - 1;
    }
};
