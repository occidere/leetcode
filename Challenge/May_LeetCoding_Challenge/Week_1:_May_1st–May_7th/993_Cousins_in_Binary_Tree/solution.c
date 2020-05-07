#include <stdio.h>
#include <stdlib.h>

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

bool isCousins(struct TreeNode* root, int x, int y)
{
    struct TreeNode* fake_node = malloc(sizeof(struct TreeNode));
    fake_node -> val = 0;

    struct TreeNode *q[101] = {root}, *parent[101] = {NULL, fake_node};
    int depth[101], head = 0, tail = 1;
    depth[root -> val] = 0;

    int x_parent, y_parent, x_depth, y_depth;
    while (head < tail)
    {
        struct TreeNode *cur = q[head++];
        int cur_val = cur -> val;

        if (cur_val == x)
        {
            x_parent = parent[cur_val] -> val;
            x_depth = depth[cur_val];
        }
        else if (cur -> val == y)
        {
            y_parent = parent[cur_val] -> val;
            y_depth = depth[cur_val];
        }

        if (cur -> left != NULL)
        {
            parent[cur -> left -> val] = cur;
            depth[cur -> left -> val] = depth[cur -> val] + 1;
            q[tail++] = cur -> left;
        }
        if (cur -> right != NULL)
        {
            parent[cur -> right -> val] = cur;
            depth[cur -> right -> val] = depth[cur -> val] + 1;
            q[tail++] = cur -> right;
        }

    }

    return x_parent != y_parent && x_depth == y_depth;
}
