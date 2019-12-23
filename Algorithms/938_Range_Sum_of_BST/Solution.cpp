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
        int rangeSumBST(TreeNode* root, int L, int R) {
            inorder(root, L, R);
            return sum;
        }

    private:
        int sum = 0;

        void inorder(TreeNode* root, int L, int R) {
            if (root) {
                inorder(root -> left, L, R);
                if (L <= (root -> val) && (root -> val) <= R) {
                    sum += (root -> val);
                }
                inorder(root -> right, L, R);
            }
        }
};
