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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int len=0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        //remove 1st node
        if(len==n) return head.next;
        int complement=len-n-1;
        temp=head;
        while(complement>0){
            temp=temp.next;
            complement--;

        }
        temp.next=temp.next.next;
        return head;
    }
}