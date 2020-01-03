#include <cstdio>
#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    vector<int> diStringMatch(string S) {
        vector<int> ans;
        int i = 0, j = S.length();
        for (char& c : S) {
            ans.push_back(c == 'I' ? i++ : j--);
        }
        ans.push_back(i);
        return ans;
    }
};
