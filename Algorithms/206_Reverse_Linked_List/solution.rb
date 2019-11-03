# frozen_string_literal: true

# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val)
#         @val = val
#         @next = nil
#     end
# end

# @param {ListNode} head
# @return {ListNode}
def reverse_list(head)
  if head
    stk = []
    node = head
    stk << node && (node = node.next) while node

    head = node = stk.pop
    (node = node.next = stk.pop) until stk.empty?
    node.next = nil
  end
  head
end