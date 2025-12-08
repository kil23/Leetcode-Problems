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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = reverse(slow);
        fast = head;

        int max = 0;
        while(fast != null && slow != null) {
            max = Math.max(max, fast.val + slow.val);
            slow = slow.next;
            fast = fast.next;
        }

        return max;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode node = head;
        while(node != null) {
            ListNode next = node.next;
            node.next  = prev;
            prev = node;
            node = next;
        }

        return prev;
    }
}