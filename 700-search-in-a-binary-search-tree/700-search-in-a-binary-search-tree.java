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
    TreeNode res;
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        
        if(val > root.val){
            res = searchBST(root.right, val);
        }else if(val < root.val){
            res = searchBST(root.left, val);
        }else{
            res = root;
        }
        
        
        return res;
    }
}