#include <cstdio>
#include <string>
using namespace std;

class Solution {
public:
    int firstUniqChar(string s) {
        int freq[26] = {0};
        for (int i = 0; i < s.length(); ++freq[s[i++] - 'a']);
        for (int i = 0; i < s.length(); ++i) {
            if (freq[s[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
};
