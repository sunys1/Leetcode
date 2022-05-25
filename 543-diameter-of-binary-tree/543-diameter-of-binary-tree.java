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
    int maxDiameter;
    public int diameterOfBinaryTree(TreeNode root) {
        //the longest path of a tree = max depth left subtree + max depth right subtree
        //find the diameter of each node and return the max
        traverse(root);
        return maxDiameter;
    }
    
    void traverse(TreeNode root){
        if(root == null){
            return;
        }
        
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        int myDiameter = leftMax + rightMax;
        
        maxDiameter = Math.max(maxDiameter, myDiameter);
        
        traverse(root.left);
        traverse(root.right);
    }
    
    int maxDepth(TreeNode root){
        //find the max depth of a tree
        if(root == null){
            return 0;
        }
        
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        
        return Math.max(leftMax, rightMax) + 1;
    }
}