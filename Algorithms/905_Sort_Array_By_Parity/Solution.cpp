#include <cstdio>
#include <vector>
#include <iterator>
using namespace std;

class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& A) {
        vector<int> odd, even;
        for (int& a : A) {
            if (a % 2) {
                odd.push_back(a);
            } else {
                even.push_back(a);
            }
        }
        even.insert(even.end(), odd.begin(), odd.end());
        return even;
    }
};
