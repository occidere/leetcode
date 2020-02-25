#include <cstdio>
#include <vector>
#include <stack>
#include <set>
using namespace std;

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> ans;
        if (!root) {
            return ans;
        }

        stk.push(root);
        while (!stk.empty()) {
            TreeNode* cur = stk.top();
            visit.insert(cur);

            if (cur -> left && (visit.find(cur -> left) == visit.end())) {
                stk.push(cur -> left);
                continue;
            } else {
                ans.push_back(cur -> val);
                stk.pop();
            }

            if (cur -> right && (visit.find(cur -> right) == visit.end())) {
                stk.push(cur -> right);
            }
        }

        return ans;
    }

private:
    stack<TreeNode*> stk;
    set<TreeNode*> visit;
};
