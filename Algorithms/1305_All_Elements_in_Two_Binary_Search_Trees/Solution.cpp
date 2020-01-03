#include <cstdio>
#include <vector>
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
    vector<int> getAllElements(TreeNode* root1, TreeNode* root2) {
        vector<int> ans, t1, t2;

        inorder(root1, t1);
        inorder(root2, t2);

        int m = t1.size(), n = t2.size();
        for (int i = 0, j = 0; i < m || j < n; ) {
            if (j >= n || (i < m && t1[i] <= t2[j])) {
                ans.push_back(t1[i++]);
            } else if (i >= m || (j < n && t1[i] > t2[j])) {
                ans.push_back(t2[j++]);
            }
        }

        return ans;
    }

private:
    void inorder(TreeNode* root, vector<int>& trace) {
        if (root) {
            inorder(root -> left, trace);
            trace.push_back(root -> val);
            inorder(root -> right, trace);
        }
    }
};
