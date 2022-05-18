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
    private ListNode successor = null;  //keep track of the node after right (if not null)
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //check if the starting node == head
        if(left == 1){
            return reverseN(head, right);
        }
        
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }
    
    public ListNode reverseN(ListNode head, int n){    
        //base case n==1
        if(n==1){
            //Keep the succssessor node
            successor = head.next;
            
            return head;
        }
        
        ListNode rev_head = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        
        return rev_head;
    }
}