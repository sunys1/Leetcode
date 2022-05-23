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
    int res = 0, depth = 0;
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }
    
    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        
        //before visiting node
        depth++;
        //when reaching a leaf node, register the depth
        if(root.left == null && root.right == null){
            res = Math.max(res, depth);
        }
        
        traverse(root.left);
        traverse(root.right);
        
        depth--;
    }
}