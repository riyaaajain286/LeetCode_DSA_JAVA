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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0){
            return head;
        }
        ListNode tail=head;
        int len=1;
        while(tail.next!=null){
          len++;
          tail=tail.next;
        }
        if(k%len==0) return head;
        k=k%len;
        tail.next=head;
        ListNode lastnode=lastnode(head,len-k);
         head=lastnode.next;
        lastnode.next=null;
        return head;

    }
    public ListNode lastnode(ListNode temp,int left){
        int c=1;
        while(temp!=null){
            if(c==left) return temp;
            c++;
            temp=temp.next;
        }
        return temp;
    }
}