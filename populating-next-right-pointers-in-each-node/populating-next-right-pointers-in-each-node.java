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
        if(root == null) return root;
        Node curr = root;
        Node prev;
        Node nextLevel;
        while(curr != null){
            nextLevel = curr.left;
            prev = null;
            while(curr != null){
                if(prev != null){
                    prev.next = curr.left;
                }
                if(curr.left != null) {
                    curr.left.next = curr.right;
                }
                prev = curr.right;
                curr = curr.next;
            }
            curr = nextLevel;
        }
        return root;
    }
}