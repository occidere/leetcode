#include <cstdio>
#include <vector>
using namespace std;

/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) { val = _val; }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
public:
    vector<int> postorder(Node* root) {
        if (root) {
            for (Node* node : root->children) {
                postorder(node);
            }
            trace.push_back(root -> val);
        }
        return trace;
    }

private:
    vector<int> trace;
};
