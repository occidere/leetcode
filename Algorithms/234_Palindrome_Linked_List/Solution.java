/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public boolean isPalindrome(ListNode head) {
        // return palindromeCheckByIndexSum(head);
        return palindromeCheckUsingSlowFastPointer(head);
    }

    /*
    Approach: slow, fast 포인터를 두고 각각 1칸씩, 2칸씩 이동 (플로이드의 토끼와 거북이 기법과 유사).
    이렇게 되면 slow 포인터는 List 중간 기준으로 나머지 절반의 시작점에 위치하게 됨 (리스트 원소가 홀수이면 1칸 더 전진).
    이후 slow 포인터부터 리스트의 끝 까지 reverse 하고, head(List 맨 처음을 가리킴) 와 slow를 1칸씩 이동하면서 값 비교

    Time Complexity: O(N)
    Space Complexity: O(1)
    */
    private boolean palindromeCheckUsingSlowFastPointer(ListNode head) {
        boolean isEven = false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null) {
                isEven = true;
            }
        }

        if (!isEven) {
            slow = slow.next;
        }

        slow = reverse(slow);
        while (slow != null) {
            if (slow.val != head.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode ret = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = ret;
            ret = head;
            head = next;
        }
        return ret;
    }
    
    /*
    Approach: 각 값마다 값에 해당하는 인덱스의 합과 등장 횟수를 기록. 값의 등장횟수 * (길이 - 1) / 2 == 값의 총합 이 성립하는지 체크
    ex)
    LinkedList = [ 1 1 2 3 2 1 1 ]
    1이 등장한 인덱스들의 합 = 0 + 1 + 5 + 6 = 12
    1이 등장한 횟수 = 4회
    공식 적용: 4 * (7 - 1) / 2 = 4 * 6 / 2 = 12

    Time Complexity: O(N + M). N = LinkedList 의 길이, M = 값의 범위 (0 ~ 9)
    Space Complexity: O(M)
    */
    private boolean palindromeCheckByIndexSum(ListNode head) {
        int[] acc = new int[10], cnt = new int[10];
        int idx = -1;
        while (head != null) {
            acc[head.val] += ++idx;
            ++cnt[head.val];
            head = head.next;
        }
        for (int i = 0; i <= 9; ++i) {
            if (acc[i] != ((cnt[i] * idx) >> 1)) {
                return false;
            }
        }
        return true;
    }
}
