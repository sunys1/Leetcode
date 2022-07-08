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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //if the list has a length of 1, return null
        if(head.next == null) return null;
        
        ListNode p1, p2, dummy;
        p1 = head;
        
        //let p1 advance n steps and it will be sz - n steps away from null
        for(int i = 0; i < n; i++){
            p1 = p1.next;
        }
        
        //let p2 locate the (n-1)th node, which is sz-n-1 steps away from head
        dummy = new ListNode(-1);
        p2 = dummy;
        p2.next = head;
        
        //as p1 advances sz-n-1 steps to the tail node, p2 advances to the (n-1)th node
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        
        //remove the target node
        p2.next = p2.next.next;
        
        return dummy.next;
    }
}