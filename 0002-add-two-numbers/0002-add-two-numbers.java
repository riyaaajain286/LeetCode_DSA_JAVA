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
     while(head1!=null || head2!=null || carry!=0){
        sum=carry;
        
        if(head1!=null){
            sum+=head1.val;
            head1=head1.next;
        }
         if(head2!=null){
            sum+=head2.val;
            head2=head2.next;
        }
        ListNode newnode=new ListNode(sum%10);
        carry=sum/10;
        temp.next=newnode;
        temp=temp.next;
    }
    
     return dummy.next;  
    }
}