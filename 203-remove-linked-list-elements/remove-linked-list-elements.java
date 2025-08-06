
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head; 
        ListNode prev = dummy; // Previous pointer
        ListNode curr = head; // Current pointer

        while (curr != null) {
            ListNode nxt = curr.next; 
            if (curr.val == val) {
               
                prev.next = nxt;
            } else {
                prev = curr; // Move prev to current
            }
            curr = nxt; // Move to the next node
        }
        return dummy.next; // Return the new head (skipping the dummy)
    }
}