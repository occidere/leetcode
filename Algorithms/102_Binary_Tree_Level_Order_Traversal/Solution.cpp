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
    vector<vector<int>> levelOrder(TreeNode* root) {
    	dfs(root, 0);
        return traversal;
    }

private:
	int max_depth = -1;
	vector<vector<int>> traversal;
	
	void dfs(TreeNode* node, int depth) {
		if (!node) {
			return;
		}
		
		if (max_depth < depth) {
			traversal.push_back(vector<int>(0));
			max_depth = depth;
		}
		traversal[depth].push_back(node -> val);
		dfs(node -> left, depth + 1);
		dfs(node -> right, depth + 1);
	}
};
