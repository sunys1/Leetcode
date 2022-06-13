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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode cur;
        q.offer(root);
        int count = 1;
        
        while(!q.isEmpty()){
            int size = q.size(); //Queue size changes in the for loop
            for(int i = 0; i < size; i++){
                cur = q.poll();
                
                if(cur.left == null && cur.right == null) return count;
                
                if(cur.left != null){
                   q.offer(cur.left);
                }

                if(cur.right != null){
                   q.offer(cur.right);
                }
            }
            count++; //increment after finishing the current level
        }
        return count;
    }
}