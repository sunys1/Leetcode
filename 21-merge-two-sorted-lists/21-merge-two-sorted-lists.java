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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(-101), temp = newHead;
        //let newHead node be a virtual head node that does not move
        //let temp node advance on behalf of the newHead node
        while(list1 != null && list2 != null){
            //before reaching the end of either list1 or list2
            //compare the values of list1 and list
            //let the temp node connect the smaller node to the merged                   list started with newHead.
            if(list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;   
            }
            
            temp = temp.next;
        }
        
        //The list that has nodes with larger values left becomes
        //the end of the new merged list
        if(list1 != null){
            temp.next = list1;
        }else if(list2 != null){
            temp.next = list2;
        }
        
        //return the real head: the first node after the newHead node.
        return newHead.next;
    }
}