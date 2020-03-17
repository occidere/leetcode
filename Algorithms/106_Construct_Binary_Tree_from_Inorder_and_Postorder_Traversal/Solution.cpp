#include <cstdio>
#include <vector>
#include <algorithm>
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
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        reverse(postorder.begin(), postorder.end());
        return find(postorder, inorder, 0, inorder.size());
    }

private:
    int idx = 0;

    TreeNode* find(vector<int>& reverse_preorder, vector<int>& inorder, int left, int right) {
        TreeNode* node = NULL;
        for (int i = left; i < right; ++i) {
            if (reverse_preorder[idx] == inorder[i]) {
                node = new TreeNode(reverse_preorder[idx++]);
                node -> right = find(reverse_preorder, inorder, i + 1, right);
                node -> left = find(reverse_preorder, inorder, left, i);
                break;
            }
        }
        return node;
    }
};
