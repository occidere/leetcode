# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val)
#         @val = val
#         @next = nil
#     end
# end

# @param {ListNode} head
# @param {Integer} val
# @return {ListNode}
def remove_elements(head, val)
  link = node = ListNode.new(nil)
  while head
    node = node.next = ListNode.new(head.val) if head.val != val
    head = head.next
  end
  link.next
end
