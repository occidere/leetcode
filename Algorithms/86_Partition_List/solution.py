# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        left = lh = ListNode(0)  # fake node
        right = rh = ListNode(0)  # fake node

        while head is not None:
            if head.val < x:
                lh.next = head
                lh = lh.next
            else:
                rh.next = head
                rh = rh.next
            head = head.next

        rh.next = None
        lh.next = right.next

        return left.next
