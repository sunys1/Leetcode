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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>res = new LinkedList<>();
        if(root == null){
            return res;
        }
        
        // Create an empty stack and push root to it
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        
        TreeNode myNode;
        while(!nodeStack.empty()){
            myNode = nodeStack.peek();
            res.add(myNode.val);
            nodeStack.pop();
            
            if(myNode.right != null){
                nodeStack.push(myNode.right);
            }
            
            if(myNode.left != null){
                nodeStack.push(myNode.left);
            }
        }
        
        return res;
    }
}