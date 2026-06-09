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
        if(head==null ||head.next==null) return;
        ListNode mid=findMiddle(head);
        //rearrange and connect
        ListNode middle=reverse(mid);
        ListNode head1=head;
        while(head1!=null && middle!=null && head1!=middle && head1.next!=middle){
            ListNode temp1=head1.next;
            head1.next=middle;
            ListNode temp2=middle.next;
            middle.next=temp1;
            head1=temp1;
            middle=temp2;
        }
       

    }
    private ListNode findMiddle(ListNode head){
       ListNode s=head,f=head;
       while(f!=null && f.next!=null){
        s=s.next;
        f=f.next.next;
       }
       return s;
    }
    private ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode prev=null,curr=head,nextnode=head;
        while(nextnode!=null){
            nextnode=nextnode.next;
            curr.next=prev;
            prev=curr;
            curr=nextnode;
        }
        return prev;
    } 
}