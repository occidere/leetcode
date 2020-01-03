#include <cstdio>
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
    TreeNode* searchBST(TreeNode* root, int val) {
        dfs(root, val);
        return find;
    }

private:
    TreeNode* find = NULL;

    void dfs(TreeNode* root, int val) {
        if (root) {
            if (root -> val == val) {
                find = root;
            } else if (root -> val > val) {
                dfs(root -> left, val);
            } else {
                dfs(root -> right, val);
            }
        }
    }
};
