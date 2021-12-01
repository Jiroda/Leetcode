/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length);
    }
    private Node helper(int[][] grid, int x, int y, int length){
        Node node = new Node(grid[x][y]!=0, true, null, null,null,null);
        
        if(length==1){
            return node;
        }
        
        Node topLeft = helper(grid, x, y, length/2);
        Node topRight = helper(grid, x, y+length/2, length/2);
        Node bottomLeft = helper(grid, x+length/2, y, length/2);
        Node bottomRight = helper(grid, x+length/2, y+length/2, length/2);
        
        if(!topLeft.isLeaf || !topRight.isLeaf || !bottomLeft.isLeaf || !bottomRight.isLeaf || topLeft.val!=topRight.val || topRight.val!=bottomLeft.val || bottomLeft.val!=bottomRight.val){
            node.isLeaf = false;
            node.topLeft = topLeft;
            node.topRight = topRight;
            node.bottomLeft = bottomLeft;
            node.bottomRight = bottomRight;
        }
        
        return node;
    }
}