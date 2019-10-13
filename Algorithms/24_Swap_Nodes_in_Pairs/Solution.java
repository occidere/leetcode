import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        // 일단 전부 stack에 담음
        ListNode h;
        for (h = head; h != null; h = h.next) {
            stack.push(h);
        }

        // 노드가 홀수면 1개 빼서 h에 세팅
        h = stack.size() % 2 == 1 ? stack.pop() : null;

        /*
        기존에 n2 -> n1 -> h 처럼 연결됬던 것을
        n1 -> n2 -> h 로 바꿔주고
        h가 n1을 가리키게 변경
         */
        while (!stack.empty()) {
            ListNode n1 = stack.pop();
            ListNode n2 = stack.pop();
            n2.next = h;
            n1.next = n2;
            h = n1;
        }

        // 위의 while문을 거치면 h는 결국 맨 첫번째 노드를 가리키게 됨
        return h;
    }
}