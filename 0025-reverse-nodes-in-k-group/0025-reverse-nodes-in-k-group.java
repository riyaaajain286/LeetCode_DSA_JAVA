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
    public ListNode reverseKGroup(ListNode head, int k) {
      ListNode prevnode=null;
        ListNode temp=head;
        while(temp!=null){
        ListNode knode=kthNode(temp,k);
        if(knode==null){
            if(prevnode!=null)
              prevnode.next=temp;
            break;
        }
        ListNode nextnode=knode.next;
        knode.next=null;
        reverse(temp);

        if(temp==head){
            head=knode;
        }
        else{
        prevnode.next=knode;
        }
        
        prevnode=temp;
        temp=nextnode;
        }
        return head;

    }
    private ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode prev=null,curr=head,next=head;
        while(next!=null){
            next=next.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    private ListNode kthNode(ListNode head,int k){
        k=k-1;
        ListNode temp=head;
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }  
    
}