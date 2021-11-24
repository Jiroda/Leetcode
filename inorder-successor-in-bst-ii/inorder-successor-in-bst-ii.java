/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        if(node.right!=null){
            return findLeftMost(node.right);
        }
        else return findParentJustGreaterThanNode(node);
    }
    
    private Node findLeftMost(Node node){
        if(node.left == null){
            return node;
        }
        return findLeftMost(node.left);
    }
    
    private Node findParentJustGreaterThanNode(Node node){
        Node par = node.parent;
        //find the parent and the parent's val needs to be < input node's val
        while(par!=null && par.val<node.val){
            par = par.parent;
        }
        return par;
    }
}