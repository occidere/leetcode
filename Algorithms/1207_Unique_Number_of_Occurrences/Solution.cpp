#include <cstdio>
#include <vector>
using namespace std;

class Solution {
public:
  bool uniqueOccurrences(vector<int>& arr) {
    sort(arr.begin(), arr.end());
    arr.push_back(0x3f3f3f3f);
    
    int counts[1001] = {0}, pre = arr[0], count = 1;
    for (int i = 1; i < arr.size(); i++, count++) {
      if (arr[i] != pre) {
        if (++counts[count] > 1) {
          return false;
        }
        pre = arr[i];
        count = 0;
      }
    }
    
    return true;
  }
};
