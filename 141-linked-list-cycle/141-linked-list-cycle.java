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
    boolean hasCycle = false;
    public boolean hasCycle(ListNode head) {
        if(head == null) return hasCycle;
        
        //pointer i, j
        ListNode i = head, j = head;
        
        //let i advances 1 step and j advance 2 steps at a time
        while(j != null && j.next != null){
            i = i.next;
            j = j.next.next;
            
            if(i == j){
                hasCycle = true;
                break;
            }
        }
        
        return hasCycle;
    }
}