#include <cstdio>
#include <vector>
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
        TreeNode* bstToGst(TreeNode* root) {
            inorder(root, true);

            int size = values.size();
            arr[values.back().first] = values.back().second;

            for (int i = size - 2; i > -1; i--) {
                pair<int, int> pre = values[i + 1], cur = values[i];
                arr[cur.first] = arr[pre.first] + cur.second;
            }

            inorder(root, false);

            return root;
        }

    private:
        int arr[101] = {0};
        vector<pair<int, int>> values;

        void inorder(TreeNode* node, bool init) {
            if (node) {
                inorder(node -> left, init);
                int val = node -> val;
                if (init) {
                    values.push_back(make_pair(val, val));
                } else {
                    node -> val = arr[val];
                }
                inorder(node -> right, init);
            }
        }
};
