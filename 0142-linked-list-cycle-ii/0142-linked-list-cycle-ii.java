/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
         if(head==null||(head.next==null)){
        return null;
       }
        ListNode s=head;
        ListNode f=head;
        while(f!=null&&f.next!=null){
            s=s.next;
            f=f.next.next;
            if(s==f){
             break;
            }
        }
        if(s!=f){//no cycle fast reaches null
            return null;
        }
        ListNode p=head;
        while(p!=s) {
            p=p.next;
            s=s.next;
        }
        return p;

    }
  
}
