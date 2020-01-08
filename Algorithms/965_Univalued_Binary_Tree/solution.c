#include <stdio.h>
#include <stdbool.h>

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

bool check(struct TreeNode* root, int k) {
    if (root) {
        if (k < 0) {
            k = root -> val;
        }

        if (k == root -> val) {
            return check(root -> left, k) && check(root -> right, k);
        } else {
            return false;
        }
    }

    return true;
}

bool isUnivalTree(struct TreeNode* root) {
    return check(root, -1);
}
