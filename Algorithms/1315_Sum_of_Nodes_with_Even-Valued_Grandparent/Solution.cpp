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
    int sumEvenGrandparent(TreeNode* root) {
        solve(root);
        return sum;
    }

private:
    int sum = 0;

    void solve(TreeNode* root) {
        if (root) {
            sum += (root -> val) % 2 ? 0 : get_grandchild_val(root);
            solve(root -> left);
            solve(root -> right);
        }
    }

    int get_grandchild_val(TreeNode* gp) {
        int k = 0;

        k += gp -> left && gp -> left -> left ? (gp -> left -> left -> val) : 0;
        k += gp -> left && gp -> left -> right ? (gp -> left -> right -> val) : 0;

        k += gp -> right && gp -> right -> left ? (gp -> right -> left -> val) : 0;
        k += gp -> right && gp -> right -> right ? (gp -> right -> right -> val) : 0;

        return k;
    }
};
