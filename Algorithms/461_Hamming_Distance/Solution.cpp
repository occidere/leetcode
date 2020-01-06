#include <cstdio>
using namespace std;

class Solution {
public:
    int hammingDistance(int x, int y) {
        int i = x ^ y, a = 0;
        for (; i > 2; a += i % 2, i >>= 1);
        return a + (i > 0);
    }
};
