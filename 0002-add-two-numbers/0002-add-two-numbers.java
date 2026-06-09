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
        ListNode curr=dummy;
        int sum=0,carry=0;
        ListNode h1=l1;
        ListNode h2=l2;
        while(h1!=null||h2!=null||carry!=0){
            sum=carry;
            if(h1!=null){
                sum+=h1.val;
                 h1=h1.next;
            }
            if(h2!=null){
                sum+=h2.val;
                h2=h2.next;
            }
            ListNode newnode=new ListNode(sum%10);
            carry=sum/10;
            curr.next=newnode;
            curr=curr.next;
        }
        // if(carry!=0){
        //     ListNode newnode=new ListNode(carry);
        //     curr.next=newnode;
        // }
        return dummy.next;
    }
}