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
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        //dfs 
        helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return ans;
    }
    
    private void helper(TreeNode root, int low, int high){
        if(root==null){
            return;
        }
        if(root.val <low){
            low = root.val;
        }
        
        if(root.val>high){
            high = root.val;
        }
        
        int diff1 = Math.abs(root.val-low);
        int diff2 = Math.abs(root.val-high);
        
        ans = Math.max(ans, Math.max(diff1, diff2));
        
        helper(root.left, low, high);
        helper(root.right, low, high);
    }
}