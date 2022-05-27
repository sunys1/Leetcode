/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        traverse(root.left, root.right);
        return root;
        
    }
    
    void traverse(Node n1, Node n2){
        if(n1 == null || n2 == null) return;
        
        //pre-order position: connect the 2 arguments
        n1.next = n2;
        
        //Traverse the left and right subtrees
        //Connect the children nodes of the left subtree
        traverse(n1.left, n1.right);
        //Connect the children nodes of the right subtree
        traverse(n2.left, n2.right);
        //Connect the right node of the left subtree and the left node of the right subtree
        //if the 2 nodes cross their parent nodes
        traverse(n1.right, n2.left);
    }
}