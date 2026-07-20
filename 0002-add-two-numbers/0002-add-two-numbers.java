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
     ListNode dummy=new ListNode(-1);
     ListNode temp=dummy;
     ListNode head1=l1,head2=l2;
     int carry=0,sum=0;
     while(head1!=null && head2!=null){
        sum=carry;
        sum+=head1.val+head2.val;
        ListNode newnode=new ListNode(sum%10);
        carry=sum/10;
        head1=head1.next;
        head2=head2.next;
        temp.next=newnode;
        temp=temp.next;
    }
     while(head1!=null){
        sum=head1.val+carry;
        carry=sum/10;
        ListNode newnode=new ListNode(sum%10);
        temp.next=newnode;
        head1=head1.next;
        temp=temp.next;
     }
        while(head2!=null){
            sum=head2.val+carry;
            carry=sum/10;
            ListNode newnode=new ListNode(sum%10);
            temp.next=newnode;
            head2=head2.next;
            temp=temp.next;

     }
     if(carry!=0){
       ListNode newnode=new ListNode(carry);
        temp.next=newnode;
     }
     return dummy.next;  
    }
}