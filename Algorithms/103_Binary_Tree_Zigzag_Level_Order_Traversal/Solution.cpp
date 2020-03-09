#include <cstdio>
#include <vector>
#include <queue>
#include <utility>
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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> traversal;

        queue<pair<TreeNode*, int>> q;
        if (root) {
            q.push(make_pair(root, 0));
        }

        while (!q.empty()) {
            TreeNode* node = q.front().first;
            int depth = q.front().second;
            q.pop();

            if (traversal.size() < depth + 1) {
                traversal.push_back(vector<int>());
            }
            traversal[depth].insert(depth % 2 ? traversal[depth].begin() : traversal[depth].end(), node -> val);

            if (node -> left) {
                q.push(make_pair(node -> left, depth + 1));
            }
            if (node -> right) {
                q.push(make_pair(node -> right, depth + 1));
            }
        }

        return traversal;
    }
};
