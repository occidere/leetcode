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
def delete_duplicates(head)
  h, cache = head, Hash.new(0)
  (cache[h.val] += 1; h = h.next) while h
  cache.select! { |k, v| v == 1 }

  node = h = ListNode.new(0)
  while head
    (h = h.next = head) if cache[head.val] == 1
    head = head.next
  end
  h.next = nil
  node.next
end