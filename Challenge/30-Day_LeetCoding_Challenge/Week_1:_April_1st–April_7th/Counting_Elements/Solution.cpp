#include <cstdio>
#include <vector>
using namespace std;

class Solution {
public:
    int countElements(vector<int>& arr) {
        int ans = 0;
        bool map[1002] = {0};
        for (int i = 0; i < arr.size(); map[arr[i++]] = 1);
        for (int i = 0; i < arr.size(); ans += map[arr[i++] + 1]);
        return ans;
    }
};

int main() {
    vector<int> v = vector<int>({1,3,2,3,5,0});
    
    Solution solution;
    int ans = solution.countElements(v);
    printf("ans = %d\n", ans);

    return 0;
}
