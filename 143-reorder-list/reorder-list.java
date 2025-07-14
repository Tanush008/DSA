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
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            st.push(temp);
            temp = temp.next;
        }
        int k = st.size() / 2;
        temp = head;
        while (k != 0) {
            ListNode topNode = st.pop();
            ListNode curr = temp.next;
            temp.next = topNode;
            topNode.next = curr;
            temp = curr;
            k--;
        }
        temp.next = null;
    }
}