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
    public void reorderList(ListNode head) {
        ListNode middle = middle(head);
        ListNode reverse = reverse(middle);
        ListNode curr = head;
        while (reverse.next != null) {
            ListNode tempCurr = curr.next;
            curr.next = reverse;
            ListNode tempRev = reverse.next;
            reverse.next = tempCurr;
            curr = tempCurr;
            reverse = tempRev;
        }
    }

    public ListNode middle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode temp = null;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = temp;
            temp = curr;
            curr = nextNode;
        }
        return temp;
    }
}