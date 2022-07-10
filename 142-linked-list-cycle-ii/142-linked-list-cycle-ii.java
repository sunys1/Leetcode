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
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        
        //pointer i, j
        ListNode i = head, j = head;
        
        //let i advances 1 step and j advance 2 steps at a time
        while(j != null && j.next != null){
            i = i.next;
            j = j.next.next;
            
            if(i == j){
                //the linked list has cycle
                hasCycle = true;
                break;
            }
        }
        
        if(hasCycle){
            //set i(or j) to head and let i,j advance at the same pace until they meet again
            i = head;
            while(i != j){
                i = i.next;
                j = j.next;
            }
            
            return i;
        }
        
        return null;
    }
}