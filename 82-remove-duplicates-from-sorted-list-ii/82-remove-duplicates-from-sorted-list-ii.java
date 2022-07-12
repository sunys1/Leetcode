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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        ListNode p1 = dummy, p2 = head;
        
        while(p2 != null){
            if(p2.next != null && p2.val == p2.next.val){
                while(p2.next != null && p2.val == p2.next.val){
                    p2 = p2.next;
                }
                p2 = p2.next; //skip the duplicates
                
                if(p2 == null) p1.next = null;
                
            }else{
                //connect non-duplicate node to dummy
                p1.next = p2;
                p1 = p1.next;
                p2 = p2.next;
            }   
        }
        
        return dummy.next;
    }
}