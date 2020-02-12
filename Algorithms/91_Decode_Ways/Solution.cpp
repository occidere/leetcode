#include <cstdio>
#include <string>
using namespace std;

class Solution {
public:
    int numDecodings(string s) {
        if(s.size() == 0) {
            return 0;
        }

        int n = s.size();
        int d[n + 1] = {1, s[0] != '0' ? 1 : 0};

        for(int i = 2; i <= n; i++) {
            int first = stoi(s.substr(i - 1, 1));
            int second = stoi(s.substr(i - 2, 2));

            if(first >= 1 && first <= 9) {
                d[i] += d[i-1];
            }

            if(second >= 10 && second <= 26) {
                d[i] += d[i-2];
            }
        }

        return d[n];
    }
};
