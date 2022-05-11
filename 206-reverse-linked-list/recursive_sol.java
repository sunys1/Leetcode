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
        //Initialize the head node of the reversed linked list
        ListNode rev_head = null;
        return recursiveCall(head, rev_head);
    }
    
    public ListNode recursiveCall(ListNode head, ListNode rev_head){
        //Loop through the linked list
        if(head == null){
            return rev_head;
        }
        
        //Keep the next node the current head node
        ListNode next = head.next;
        //Make the current head node the first node in the reversed list
        head.next = rev_head;
        rev_head = head;

        //Now the head node is in the reversed list, move the head pointr to the next node
        head = next;
        
        return recursiveCall(head, rev_head);
    }
}
