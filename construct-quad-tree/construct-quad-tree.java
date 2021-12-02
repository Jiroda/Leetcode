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
        return recursiveHelper(grid, 0, 0, grid.length);
    }
    
    public Node recursiveHelper(int[][] grid, int row, int col, int length){
        if(length==1){
            //we have a leaf
            return new Node(grid[row][col]!=0, true, null, null, null, null);
        }
        
        Node topLeft = recursiveHelper(grid, row, col, length/2);
        Node topRight = recursiveHelper(grid, row, col+length/2, length/2);
        Node bottomLeft = recursiveHelper(grid, row+length/2, col, length/2);
        Node bottomRight = recursiveHelper(grid, row+length/2, col+length/2, length/2);
        
        //All the 4 nodes are leaves and they have the same value, then we merge all of them into one single node and return
        if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
           && topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val){
               return new Node(topLeft.val, true, null, null, null, null);
        }else{
            //If the current grid has different values, set isLeaf to False and set val to *any value* and divide the current grid into four sub-grids as shown in the photo.
            return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}