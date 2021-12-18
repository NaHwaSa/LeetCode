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
    ListNode answer = null;
    ListNode iter = null;

    private void add(int val) {
        if (iter == null) {
            answer = new ListNode(val);
            iter = answer;
            return;
        }

        iter.next = new ListNode(val);
        iter = iter.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode iter = null;
        if (k <= 1)
            return head;

        int idx = 0;
        int[] tmp = new int[k];
        while (true) {
            tmp[idx++] = head.val;
            head = head.next;

            if (idx == k) {
                idx = 0;
                for (int i = k-1; i >= 0; i--) {
                    add(tmp[i]);
                }
            }

            if (head == null) {
                for (int i = 0; i < idx; i++) {
                    add(tmp[i]);
                }
                break;
            }
        }
        return answer;
    }
}
