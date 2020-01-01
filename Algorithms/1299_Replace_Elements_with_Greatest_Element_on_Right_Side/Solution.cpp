#include <cstdio>
#include <vector>
using namespace std;

class Solution {
public:
  vector<int> replaceElements(vector<int>& arr) {
    vector<int> ans({-1});
    int m = -1;
    for (int i = arr.size() - 1; i > 0; i--) {
      m = m < arr[i] ? arr[i] : m;
      ans.push_back(m);
    }
    reverse(ans.begin(), ans.end());
    return ans;
  }
};
