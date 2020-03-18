#include <cstdio>
#include <vector>
#define LEFT 0
#define RIGHT 1
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
    TreeNode* getTargetCopy(TreeNode* original, TreeNode* cloned, TreeNode* target) {
        dfs(original, target, vector<int>());
        for (int i = 0; i < traced.size(); ++i) {
            cloned = traced[i] == LEFT ? cloned -> left : cloned -> right;
        }
        return cloned;
    }

private:
    vector<int> traced;

    void dfs(TreeNode* root, TreeNode* target, vector<int> trace) {
        if (!root) {
            return;
        }

        if (root == target) {
            traced = trace;
            return;
        } else {
            trace.push_back(LEFT);
            dfs(root -> left, target, trace);
            trace.pop_back();

            trace.push_back(RIGHT);
            dfs(root -> right, target, trace);
            trace.pop_back();
        }
    }
};
