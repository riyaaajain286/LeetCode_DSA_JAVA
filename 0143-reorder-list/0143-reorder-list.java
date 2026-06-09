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
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        int c=0;
        if(len%2==0){
             c=len/2;
        }
        else{
             c=len/2+1;
        }
        temp=head;
        while(c>1){
          temp=temp.next;
          c--;
        }
        //rearrange and connect
        ListNode middle=reverse(temp);
        ListNode head1=head;
        while(head1!=null && middle!=null){
            ListNode temp1=head1.next;
            head1.next=middle;
            ListNode temp2=middle.next;
            middle.next=temp1;
            head1=temp1;
            middle=temp2;
        }
       

    }
    private ListNode reverse(ListNode head){
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