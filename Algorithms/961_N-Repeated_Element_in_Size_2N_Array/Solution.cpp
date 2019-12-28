#include <cstdio>
#include <vector>
using namespace std;

class Solution {
public:
    int repeatedNTimes(vector<int>& A) {
        int freq[10000] = {0}, n = A.size() / 2;
        for (int& a : A) {
            freq[a]++;
            if (freq[a] == n) {
                return a;
            }
        }
        return 0;
    }
};
