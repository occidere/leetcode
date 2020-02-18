#include <cstdio>
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
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        if (m == n) {
            return head;
        }

        ListNode* node = NULL, *fake = new ListNode(0);
        ListNode* bfr = NULL, *cur = fake, *aft = NULL;
        fake -> next = head;

        for (int i = 0; cur && i <= n; i++, bfr = cur, cur = aft) {
            aft = cur -> next;
            if (m <= i && i <= n) {
                if (i == n) {
                    node -> next -> next = cur -> next;
                    node -> next = cur;
                }
                cur -> next = bfr;
            } else if (i == m - 1) {
                node = cur;
            }
        }

        return fake -> next;
    }
};
