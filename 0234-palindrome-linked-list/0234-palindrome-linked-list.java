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
      if(head==null||head.next==null) return true;
        //find middle
        ListNode slow=head;
        ListNode fast=head;
        //fast.next for odd length and fast.next.next for even
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondhead=reverse(slow.next);
        //reverse second half of list
        ListNode first=head;
        ListNode second=secondhead;
        while(second!=null){
            if(first.val!=second.val){
                reverse(secondhead);
                return false;
            }
            first=first.next;
            second=second.next;
         }
         reverse(slow.next);
         return true;

    }
    private ListNode reverse(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode temp=head;
        ListNode next=head;
        ListNode prev=null;
        while(next!=null){
            next=next.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
    }
}