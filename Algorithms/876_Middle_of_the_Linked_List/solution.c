#include <stdio.h>

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* middleNode(struct ListNode* head){
    struct ListNode* nodes[100];
    int n = 0;
    while (head) {
        nodes[n++] = head;
        head = head -> next;
    }
    return nodes[n / 2];
}
