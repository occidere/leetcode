#include <cstdio>
#include <cstdint>
using namespace std;

class Solution {
public:
    int hammingWeight(uint32_t n) {
        int a = 0;
        uint32_t i = n;
        for (; i > 2; a += i % 2, i >>= 1);
        return a + (i > 0);
    }
};
