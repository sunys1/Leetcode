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
    public ListNode partition(ListNode head, int x) {
        ListNode h1 = new ListNode(-1); //list of nodes < x
        ListNode h2 = new ListNode(-1); //list of nodes >= x
        ListNode n1 = h1, n2 = h2;
        
        while(head != null){
            if(head.val < x){
                n1.next = head;
                n1 = n1.next;
            }else{
                n2.next = head;
                n2 = n2.next;
                
            }
            
            //Break the original links
            ListNode temp = head.next;
            head.next = null;
            head = temp;
        }
        
        //connect the 2 lists
        n1.next = h2.next;
        
        return h1.next;
    }
}