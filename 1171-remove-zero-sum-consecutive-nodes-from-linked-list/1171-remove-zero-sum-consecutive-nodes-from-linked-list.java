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
    public ListNode removeZeroSumSublists(ListNode head) {
         // Dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        HashMap<Integer, ListNode> map = new HashMap<>();
        int prefixSum = 0;
        
        // First pass: store latest occurrence of each prefix sum
        ListNode curr = dummy;
        while (curr != null) {
            prefixSum += curr.val;
            map.put(prefixSum, curr);
            curr = curr.next;
        }
        
        // Second pass: remove zero sum nodes
        prefixSum = 0;
        curr = dummy;
        while (curr != null) {
            prefixSum += curr.val;
            curr.next = map.get(prefixSum).next;
            curr = curr.next;
        }
        
        return dummy.next;
    }
}