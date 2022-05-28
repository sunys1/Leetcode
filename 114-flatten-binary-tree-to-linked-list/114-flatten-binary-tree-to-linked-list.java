/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
//     public void flatten(TreeNode root) {
//         if(root == null) return;
        
        
//         //flatten the left and the right subtrees
//         flatten(root.left);
//         flatten(root.right);
        
//         //for each node, 
//         //1. set its left subtree as its new right subtree.
//         //2. connect the old right subtree to the end of new right subtree.
        
//         TreeNode left = root.left;
//         TreeNode right = root.right;
        
//         root.left = null;
//         root.right = left;
        
//         TreeNode temp = root;
//         while(temp.right != null){
//             temp = temp.right;
//         }
        
//         temp.right = right;
//     }
        TreeNode prev=null;
        public void flatten(TreeNode root) {
            if(root==null)  return;
            flatten(root.right);
            flatten(root.left);
            root.right=prev;
            root.left=null;
            prev=root;
        }
}