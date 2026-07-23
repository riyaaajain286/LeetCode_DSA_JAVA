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
    //using priority queue
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node:lists){
            if(node!=null)
              pq.add(node);
        }
        ListNode ans=new ListNode(-1);
        ListNode temp=ans;
        while(!pq.isEmpty()){
            ListNode pop=pq.poll();
            temp.next=pop;
            temp=temp.next;
            if(pop.next!=null)
             pq.add(pop.next);
        }
        return ans.next;
    }
}