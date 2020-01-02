#include <cstdio>
#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    vector<int> selfDividingNumbers(int left, int right) {
        vector<int> ans;
        for (int i = left; i <= right; i++) {
            bool is_self_dividing_number = true;
            for (char& c : to_string(i)) {
                if (c == 48 || (i % (c - 48))) {
                    is_self_dividing_number = false;
                    break;
                }
            }
            if (is_self_dividing_number) {
                ans.push_back(i);
            }
        }
        return ans;
    }
};
