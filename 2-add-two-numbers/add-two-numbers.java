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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // Stack<ListNode>s1 = new Stack<>();
        // ListNode curr = l1;
        // while(curr!=null){
        //     s1.push(curr.val);
        //     curr = curr.next;
        // }
        // Stack<Integer>s2 = new Stack();
        // ListNode curr2 = l2;
        // while(curr2!=null){
        //     s2.push(curr2.val);
        //     curr2 = curr2.next;
        // }
        // int sum = 0;
        // while(!s1.isEmpty()&&!s2.isEmpty()){
        //     int elem1= s1.pop();
        //     int elem2 = s2.pop();
        //     sum = elem1+elem2;
        // }
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int x = 0, y = 0;
            if (l1 != null) {
                x = l1.val;
                l1 = l1.next;
            } else {
                x = 0;
            }
            if (l2 != null) {
                y = l2.val;
                l2 = l2.next;
            } else {
                y = 0;
            }
            int sum = x + y + carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return dummy.next;
    }
}