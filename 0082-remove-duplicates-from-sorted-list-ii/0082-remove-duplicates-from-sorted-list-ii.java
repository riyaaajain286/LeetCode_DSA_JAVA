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
    public ListNode deleteDuplicates(ListNode head) {
         ListNode dum = new ListNode(); // dummy bouncer
        dum.next = head;
        ListNode curr = head;
        ListNode prev = dum;

        while(curr != null) {
            if(curr.next != null && curr.val == curr.next.val) {
                // skip all duplicates
                while(curr.next != null && curr.val == curr.next.val)
                    curr = curr.next;
                prev.next = curr.next; // remove the twins
                curr = prev.next;      // continue
            } else {
                curr = curr.next;  // move both pointers
                prev = prev.next;
            }
        }

        return dum.next; // only the unique ones remain
    }
}