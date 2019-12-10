#include <cstdio>
#include <string>
using namespace std;

class Solution {
public:
    string toLowerCase(string str) {
        for (char& ch : str) {
            if (64 < ch && ch < 91) {
                ch += 32;
            }
        }
        return str;
    }
};
