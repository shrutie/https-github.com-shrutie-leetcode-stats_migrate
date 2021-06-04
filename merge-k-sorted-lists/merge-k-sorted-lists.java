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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>( (a,b) -> a.val-b.val);
        
        for(ListNode node : lists){
            if(node!=null)
              minHeap.add(node);
        }
        
        ListNode ptr1 = null, ptr2 = null;
        while(!minHeap.isEmpty()){
            ListNode n = minHeap.poll();
            if(ptr1 == null){
                ptr1 = ptr2 =n;
            }
            else{
                ptr2.next = n;
                ptr2 = ptr2.next; 
            }
            if(n.next != null){
                minHeap.offer(n.next);
            }
        }
        
        
        return ptr1;
    }
}