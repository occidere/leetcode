# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val)
#         @val = val
#         @next = nil
#     end
# end

# @param {ListNode} head
# @param {Integer} k
# @return {ListNode}
def rotate_right(head, k)
  node, len = head, 0
  node, len = node.next, len + 1 while node

  return head if len == 0 or k % len == 0

  h, mov = head, len - (k % len)
  mov.times.each { |_| h = h.next }
  node = h

  (len - 1).times.each do |_|
    node.next = head unless node.next
    node = node.next
  end

  node.next = nil
  h
end