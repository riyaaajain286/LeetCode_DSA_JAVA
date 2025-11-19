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
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp=head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prev=dummy;
        while(temp!=null){
            if(temp.val==val){
                // if(temp==head){
                //     head=head.next;
                // }
                ListNode nextnode=temp.next;
                prev.next=nextnode;
               
                // prev=temp;
                }
                else{
                    prev=temp;
                }
                temp=temp.next;;
                }
           
    
        return dummy.next;
    }
}