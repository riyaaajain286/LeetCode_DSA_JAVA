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
        if(head==null||head.next==null)  return;
        //find middle
        ListNode s=head;
        ListNode f=head;
        while(f!=null&&f.next!=null){
        s=s.next;
        f=f.next.next;
        }
        ListNode p=head;
        //reverse second half
        ListNode q=reverse(s.next);
        s.next=null;
        //merge and reorder
        while(q!=null){
        ListNode temp1=p.next;
        ListNode temp2=q.next;
        p.next=q;
        q.next=temp1;
        p=temp1;
        q=temp2;
        }
       
    }
  public static ListNode reverse(ListNode head){
    ListNode prev=null;
    ListNode temp=head;
    ListNode nextnode=head;
    while(nextnode!=null){
      nextnode=nextnode.next;
      temp.next=prev;
      prev=temp;
      temp=nextnode;
    }
    return head=prev;
    }
}