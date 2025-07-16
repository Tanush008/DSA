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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode temp = head;
        int len = 1;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
        temp.next = head;
        int rotation = k % len;
        int skip = len - rotation;
        ListNode newNode = head;
        for (int i = 0; i < skip - 1; i++) {
            newNode = newNode.next;
        }
        head = newNode.next;
        newNode.next = null;
        return head;
    }
}