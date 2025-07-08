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
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode curr = head;
        if(head==null){
            return null;
        }
        while(temp!=null){
           ListNode nextNode = temp.next;
           temp.next = curr;
            curr = temp;
            temp = nextNode;
        }
        head.next = null;
        head = curr;
        return head;
    }
}