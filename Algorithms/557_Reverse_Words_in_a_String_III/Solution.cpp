#include <cstdio>
#include <string>
#include <algorithm>
using namespace std;

class Solution {
public:
    string reverseWords(string s) {
        string rs = "";
        size_t pos = 0;
        while ((pos = s.find(" ")) != string::npos) {
            string tmp = s.substr(0, pos);
            reverse(tmp.begin(), tmp.end());
            rs += tmp + " ";
            s.erase(0, pos + 1);
        }
        reverse(s.begin(), s.end());
        return rs + s;
    }
};
