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

//T:O(n)
//S:O(n)
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        Pair pair = dfs(root);
        return pair.diameter;
    }
    
    private Pair dfs(TreeNode root){
        //Height of null node is -1 only then height of a leaf can become zero
        if(root==null){
            return new Pair(-1,0);
        }
        
        Pair leftPair = dfs(root.left);
        Pair rightPair = dfs(root.right);
        
        int heightOfthisNode = Math.max(leftPair.height, rightPair.height)+1; 
        int maxDiameter = Math.max(leftPair.diameter, rightPair.diameter); 
        
        //We have two cases, the diameter can pass through root, doesnt not have to pass through root
        //if it passes through root dia = left height + right height +2 for two edges between root and nodes
        //if it doesnt pass through root dia = max(diameter of left subtree, diameter of right subtree)
        int diameterOfThisNode = Math.max(leftPair.height+rightPair.height+2, maxDiameter);
        
        return new Pair(heightOfthisNode, diameterOfThisNode);
    }
}

class Pair{
    int height;
    int diameter;
    public Pair(int height, int diameter){
        this.height = height;
        this.diameter = diameter;
    }
}