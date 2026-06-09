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
        if(head==null || head.next==null) return true;
        ListNode h1=head;
        ListNode h2=reverse(mid(head));
        while(h1!=null && h2!=null){
            if(h1.val!=h2.val){
                return false;
            }
            h1=h1.next;
            h2=h2.next;

        }
        return true;

    }
    private ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode prev=null,curr=head,next=head;
        while(next!=null){
            next=next.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    private ListNode mid(ListNode head){
        ListNode s=head,f=head;
        while(f!=null &&f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        return s;
    }
}