# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        node: ListNode = ListNode(-1)
        h = node
        cache: Set = set()

        while head:
            if head.val not in cache:
                cache.add(head.val)
                node.next = ListNode(head.val)
                node = node.next
            head = head.next

        return h.next

