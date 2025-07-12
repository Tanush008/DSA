/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null) {
            return null;
        }
        if (headB == null) {
            return null;
        }
        int diff = getDiff(headA, headB);
        if (diff < 0) {
            while (diff++ != 0) {
                headB = headB.next;
            }
        } else {
            while (diff-- != 0) {
                headA = headA.next;
            }
        }
        while (headA != null) {
            if (headA == headB) {
                return headB;
            }
            headB = headB.next;
            headA = headA.next;
        }
 
        return headB;
    }

    public int getDiff(ListNode headA, ListNode headB) {
        int l1 = 0;
        int l2 = 0;
        while (headA != null || headB != null) {
            if (headA != null) {
                l1++;
                headA = headA.next;
            }
            if (headB != null) {
                l2++;
                headB = headB.next;
            }
        }
        return l1 - l2;
    }
}