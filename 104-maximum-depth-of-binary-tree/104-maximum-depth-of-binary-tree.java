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
        if (root == null) {
            return 0;
        }
        // 利用定义，计算左右子树的最大深度
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // 整棵树的最大深度等于左右子树的最大深度取最大值，
        // 然后再加上根节点自己
        int res = Math.max(leftMax, rightMax) + 1;

        return res;
    }
    
//     public void traverse(TreeNode root){
//         if(root == null){
//             return;
//         }
        
//         //before visiting node
//         depth++;
//         //when reaching a leaf node, register the depth
//         if(root.left == null && root.right == null){
//             res = Math.max(res, depth);
//         }
        
//         traverse(root.left);
//         traverse(root.right);
        
//         depth--;
//     }
}