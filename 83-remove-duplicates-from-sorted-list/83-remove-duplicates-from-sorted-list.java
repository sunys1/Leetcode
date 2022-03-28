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
        if (head == null) return null;
        //Define 2 pointers i, j; i moves slower than j;
        ListNode i = head, j = head;
        
        while(j != null){
            if(j.val != i.val){
                i.next = j;
                i = i.next;
            }
            j = j.next;
        }
        
        i.next = null;
        
        return head;
    }
}