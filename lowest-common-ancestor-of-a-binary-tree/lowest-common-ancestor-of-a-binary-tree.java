/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || root==p || root ==q){
            return root;
        }
        TreeNode leftSubtreeResult = helper(root.left, p, q);
        TreeNode rightSubtreeResult = helper(root.right, p, q);
        
        if(leftSubtreeResult!=null && rightSubtreeResult!=null){
            return root;
        }
        
        if(leftSubtreeResult==null){
            return rightSubtreeResult;
        }else{
            return leftSubtreeResult;
        }
    }
}