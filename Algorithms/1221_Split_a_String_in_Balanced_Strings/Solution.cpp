#include <cstdio>
#include <string>
using namespace std;

class Solution {
    public:
        int balancedStringSplit(string s) {
            int count = 0, l = 0, r = 0;

            for (char& c : s) {
                if (c == 'L') {
                    l++;
                } else {
                    r++;
                }

                if (l == r) {
                    count++;
                    l = r = 0;
                }
            }

            return count;
        }
};
