#include <vector>
#include <cstdio>
using namespace std;

class Solution {
public:
    int largestAltitude(vector<int>& gain) {
        int max_h = max(0, gain[0]);
        for (int i = 1; i < gain.size(); ++i) {
            gain[i] += gain[i - 1];
            max_h = max(max_h, gain[i]);
        }
        return max_h;
   }
};
