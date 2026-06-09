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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode ans=new ListNode(-1);
        ListNode temp=ans;
        ListNode h1=list1,h2=list2;
        while(h1!=null && h2!=null){
            if(h1.val>h2.val){
                temp.next=h2;
                h2=h2.next;
            }
            else{
                temp.next=h1;
                h1=h1.next;
            }
            temp=temp.next;
        }
        if(h1!=null){
            temp.next=h1;
            h1=h1.next;
        }
        if(h2!=null){
            temp.next=h2;
            h2=h2.next;
        }
        return ans.next;
    }
}