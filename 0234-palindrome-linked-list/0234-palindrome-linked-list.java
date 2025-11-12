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
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
         ListNode s=head;
    ListNode f=head;
    while(f!=null&&f.next!=null){
      s=s.next;
      f=f.next.next;
    }
    ListNode first=head;
    ListNode second=reverse(s);
    ListNode secondhead=second;
    while(secondhead!=null){
      if(first.val!=secondhead.val){
        reverse(s);;
        return false;
        
      }
      first=first.next;
      secondhead=secondhead.next;
      }
    reverse(s);
    return true;
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