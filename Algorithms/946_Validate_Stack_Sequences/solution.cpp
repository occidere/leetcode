#include <cstdio>
#include <vector>
#include <stack>
using namespace std;

class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        stack<int> stk;
        int i = 0, n = pushed.size();
        
        for (int element : pushed) {
            stk.push(element);
            
            while (!stk.empty() && stk.top() == popped[i]) {
                stk.pop();
                ++i;
            }
        }

        return stk.empty();
    }
};
