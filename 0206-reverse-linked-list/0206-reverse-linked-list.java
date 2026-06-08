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
        if(head==null) return head;
        ListNode curr=head;
        ListNode prev=null;
        ListNode nextnode=head;
        while(curr!=null){
            nextnode=nextnode.next;
            curr.next=prev;
            prev=curr;
            curr=nextnode;
        }
        return prev;
    }
}