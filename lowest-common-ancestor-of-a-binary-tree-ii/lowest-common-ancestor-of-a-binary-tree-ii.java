/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//T:O(n)
//S:O(h) h->height of the tree
class Solution {
    boolean pFound = false;
    boolean qFound = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = helper(root, p, q);
        if(pFound && qFound){
            return lca;
        }
        return null;
    }
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return root;
        }
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        if(root==p){
            pFound=true;
            return root;
        }
    
        if(root==q){
            qFound=true;
            return root;
        }
        
        if(left==null){
            return right;
        }
        
        if(right==null){
            return left;
        }
        
        return root;
    }
}