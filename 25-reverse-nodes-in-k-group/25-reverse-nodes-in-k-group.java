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
    ListNode successor = null, temp = null;
    int counter = 0;
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a, b;
        a = b = head;
        
        for(int i = 0; i < k; i++){
            if(b == null) return head;
            temp = b;
            b = b.next;
        }
        
        //reverse the first k nodes
        ListNode rev_head = reverseN(a, k);
        temp.next = reverseKGroup(b, k);
        
        return rev_head;
    }
    
    public ListNode reverseN(ListNode head, int n){
        //base case
        if(n == 1){
            successor = head.next;
            return head;
        }
        
        ListNode rev_head = reverseN(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        temp = head;
        
        return rev_head;
    }
}