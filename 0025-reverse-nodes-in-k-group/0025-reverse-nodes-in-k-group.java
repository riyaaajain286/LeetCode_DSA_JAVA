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
        ListNode temp=head;
        ListNode prevnode=null;
        while(temp!=null){
            ListNode kthNode=knode(temp,k);
            if(kthNode==null){
                if(prevnode!=null){
                    prevnode.next=temp;
                }
                break;
            }
            ListNode nextnode=kthNode.next;
            kthNode.next=null;
            reverse(temp);
            //while reversing 1st set temp which is kth node will become head of reversed ll therefore make it as newhead now
            // First group
            if(temp==head)
              head=kthNode;
            //connecting reversed list with last set of list
            else{
              prevnode.next=kthNode;
            }
            prevnode=temp;
            temp=nextnode;
        }
        return head;
    }
    private ListNode knode(ListNode head,int k){
        k-=1;
        ListNode temp=head;
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
        }
        return temp;
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
}