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
        //Check lists length
        if(lists.length == 0){
            return null;    
        }
         //Create a dummy node as the start of the merged list
        //It's dummy such that we use it to return the merged list at the end
        ListNode dummy = new ListNode(-1);
        //Create a pointer p for the merged list
        ListNode p = dummy;
        //Create a priority queue of type ListNode of ascending order
        //provide the initial length and the comparator
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (i,j)->(i.val - j.val)); 
        
        //Add the head nodes of the lists to the priority queue in order
        for(ListNode head : lists){
            if(head != null){
                pq.add(head);
            }
        }
        
        //merge the lists
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            p.next = node;
            //add the linked nodes to pq if exist
            if(node.next != null){
                pq.add(node.next);
            }
            //Advance the pointer p to get ready for the next new node
            p = p.next;
        }
        
        return dummy.next;
    }
}