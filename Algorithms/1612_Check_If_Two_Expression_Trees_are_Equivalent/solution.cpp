#include <cstdio>
#include <map>
using namespace std;

/**
 * Definition for a binary tree node.
 * struct Node {
 *     char val;
 *     Node *left;
 *     Node *right;
 *     Node() : val(' '), left(nullptr), right(nullptr) {}
 *     Node(char x) : val(x), left(nullptr), right(nullptr) {}
 *     Node(char x, Node *left, Node *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool checkEquivalence(Node* root1, Node* root2) {
        map<char, int> m1 = create_map();
        map<char, int> m2 = create_map();
        inorder(root1, &m1);
        inorder(root2, &m2);
        return is_equal(m1, m2);
    }

private:
    map<char, int> create_map() {
        map<char, int> freq = *new map<char, int>();
        for (char c = 'a'; c <= 'z'; ++c) {
            freq[c] = 0;
        }
        return freq;
    }

    void inorder(Node *root, map<char, int> *freq) {
        if (root) {
            inorder(root -> left, freq);
            if (root -> val != '+') {
                (*freq)[root -> val]++;
            }
            inorder(root -> right, freq);
        }
    }

    bool is_equal(map<char, int> m1, map<char, int> m2) {
        for (char c = 'a'; c <= 'z'; ++c) {
            if (m1[c] != m2[c]) {
                return false;
            }
        }
        return true;
    }
};
