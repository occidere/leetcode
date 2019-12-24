#include <cstdio>
#include <string>
using namespace std;

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    int getDecimalValue(ListNode* head) {
        string b_str = "";
        while (head) {
            b_str += to_string(head -> val);
            head = (head -> next);
        }
        return stoi(b_str, NULL, 2);
    }
};
