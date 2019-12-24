#include <cstdio>
#include <string>
using namespace std;

class Solution {
public:
    int subtractProductAndSum(int n) {
        int a = 1, b = 0;
        for (char& c : to_string(n)) {
            a *= (c - 48);
            b += (c - 48);
        }
        return a - b;
    }
};
