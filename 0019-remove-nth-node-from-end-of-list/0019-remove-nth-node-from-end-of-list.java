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
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        //remove 1st node
        if(len==n) return head.next;
        int needed=len-n-1;
        temp=head;
        while(needed>0){
            temp=temp.next;
            needed--;
        }
        temp.next=temp.next.next;
        return head;
    }
}