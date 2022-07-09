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
    public ListNode middleNode(ListNode head) {
        //pointer i, j
        ListNode i = head, j = head;
        
        //let i advances 1 step and j advance 2 steps every time
        while(j != null && j.next != null){
            i = i.next;
            j = j.next;
            if(j != null){
                j = j.next;
            }
        }
        
        //when j points to null, i is at the middle node of an odd length list or at the 
        //second middle node of an even length list.
        return i;
    }
}