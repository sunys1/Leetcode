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
        int count = 0;
        
        while(head != null){
            if(head.val < x){
                n1.next = head;
                n1 = n1.next;
                // System.out.print(n1.val + " -> ");
            }else{
                n2.next = head;
                n2 = n2.next;
                // System.out.print(n2.val + " -> ");
            }
            
            head = head.next;
            // //Break the original links
            // ListNode temp = head.next;
            // head.next = null;
            // head = temp;
        }
        
        //connect the 2 lists
        n1.next = h2.next;
        n2.next = null;
        // // System.out.println(n1.next.val);
        // while(h1.next != null && count < 10){
        //     System.out.println(h1.next.val);
        //     h1 = h1.next;
        //     count++;
        // }
        
        return h1.next;
    }
}