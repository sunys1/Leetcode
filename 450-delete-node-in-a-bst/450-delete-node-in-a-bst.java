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
    public TreeNode deleteNode(TreeNode root, int key) {
        //base case
        if (root == null) return null;
        //1. find the key
        if(root.val == key){
            //delete key node
            //1. if the key node is a leaf node
            if(root.left == null && root.right == null){
                return null;
            //2. if the key node has only 1 child
            }else if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            //3. if the key node has both left and right child
            //find the min node of the right subtree
            TreeNode min = getMin(root.right);
            
            //remove the min node
            root.right = deleteNode(root.right, min.val);
            
            //replace root node with min node
            min.left = root.left;
            min.right = root.right;
            root = min;
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        
        return root;
    }
    
    TreeNode getMin(TreeNode node) {
        // In BST, the leftmost node is the min
        while (node.left != null) node = node.left;
        return node;
    }
}