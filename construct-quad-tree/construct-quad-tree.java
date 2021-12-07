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
        return helper(grid, grid.length, 0, 0);
    }
    
    private Node helper(int[][] grid, int size, int row, int col){
        if(size==1){
            return new Node(grid[row][col]!=0, true, null, null, null, null);
        }
        
        Node topLeft = helper(grid, size/2, row, col);
        Node topRight = helper(grid, size/2, row, col+size/2);
        Node bottomLeft = helper(grid, size/2, row+size/2, col);
        Node bottomRight = helper(grid, size/2, row+size/2, col+size/2);
        
        if(!topLeft.isLeaf || !topRight.isLeaf || !bottomLeft.isLeaf || !bottomRight.isLeaf || topLeft.val !=topRight.val || topRight.val !=bottomLeft.val || bottomLeft.val !=bottomRight.val){
            return new Node(topLeft.val, false, topLeft, topRight, bottomLeft, bottomRight);
        }
        
        return new Node(grid[row][col]!=0, true, null, null, null, null);
        
    }
}