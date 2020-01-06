#include <cstdio>
#include <string>
using namespace std;

class Solution {
public:
    bool judgeCircle(string moves) {
        int a[2] = {0};
        for (char& c : moves) {
            switch (c) {
                case 'U': a[0]++; break;
                case 'D': a[0]--; break;
                case 'L': a[1]++; break;
                case 'R': a[1]--; break;
            }
        }
        return !a[0] && !a[1];
    }
};
