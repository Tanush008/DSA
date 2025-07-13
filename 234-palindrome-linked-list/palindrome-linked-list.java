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
        if (head == null || head.next == null) {
            return true;
        }
        ListNode middle = middle(head);
        ListNode reverse = reverse(middle);
        ListNode temp = head;
        while (reverse != null) {
            if (temp.val != reverse.val) {
                return false;
            }
            temp = temp.next;
            reverse = reverse.next;
        }
        return true;
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