#include <cstdio>
#include <cstdint>
using namespace std;

class Solution {
public:
    int findComplement(int num) {
        uint32_t k = 1;
        while ((k <<= 1) <= num);
        return num ^ (k - 1);
    }
};
