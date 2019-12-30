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
    int deepestLeavesSum(TreeNode* root) {
        dfs(root, 0);
        return depth_sum[max_depth];
    }

private:
    int max_depth = 0;
    int depth_sum[10000] = {0};

    void dfs(TreeNode* node, int depth) {
        if (node -> left) {
            dfs(node -> left, depth + 1);
        }
        if (node -> right) {
            dfs(node -> right, depth + 1);
        }
        if (!(node -> left) && !(node -> right)) {
            depth_sum[depth] += (node -> val);
            max_depth = depth > max_depth ? depth : max_depth;
        }
    }
};
