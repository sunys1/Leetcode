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
    public ListNode reverseList(ListNode head) {
        //Initialize a head Node for the reversed list
        ListNode rev_head = null;
        //Loop through the linked list
        if(head == null){
            return head;
        }
        
        while(head != null){
            //Keep the next node of the current head node
            ListNode next = head.next;
            //Make the current head node the first node in the reversed list
            head.next = rev_head;
            rev_head = head;
            
            //Now the head node is in the reversed list, move the head pointer to the next node
            head = next;
        }
        
        head = rev_head;
        
        return head;
    }
}
