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
    ArrayList<Integer> nodes = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        nodes = traverse(root);
        int left = 0, right = nodes.size() - 1, sum;
        while(left < right){
            sum = nodes.get(left) + nodes.get(right);
            if(sum < k){
                left++;
            }else if(sum > k){
                right--;
            }else{
                return true;
            }
        }
        
        return false;
    }
    
    public ArrayList<Integer> traverse(TreeNode root){
        //use in-order traversal to achieve a sorted integer list
        if(root == null) return nodes;
        
        nodes = traverse(root.left);
        nodes.add(root.val);
        nodes = traverse(root.right);
        
        return nodes;
    }
}