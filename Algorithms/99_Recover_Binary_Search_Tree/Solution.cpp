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
    void recoverTree(TreeNode* root) {
        inorder(root);

        int tmp = first -> val;
        first -> val = second -> val;
        second -> val = tmp;
    }

private:
    TreeNode *prev = NULL, *first = NULL, *second = NULL;

    void inorder(TreeNode* node) {
        if (node) {
            inorder(node -> left);

            if (prev && prev -> val > node -> val) {
                first = first == NULL ? prev : first;
                second = node;
            }
            prev = node;

            inorder(node -> right);
        }
    }
};
