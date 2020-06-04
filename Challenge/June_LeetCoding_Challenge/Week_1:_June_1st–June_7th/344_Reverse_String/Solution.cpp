#include <cstdio>
#include <vector>
using namespace std;

class Solution {
    public:
        void reverseString(vector<char>& s) {
            int len = s.size();
            int half = len / 2;
            for (int i = 0; i < half; i++) {
                char ch = s[i];
                s[i] = s[len - i - 1];
                s[len - i - 1] = ch;
            }
        }
};
