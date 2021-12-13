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
    int count=0;
    public int goodNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        return helper(root, root.val);
    }
    
    private int helper(TreeNode root, int maxValueSoFar){
        if(root==null){
            return 0;
        }
        
        if(root.val>=maxValueSoFar){
            count+=1;
            maxValueSoFar = root.val;
        }
        
        helper(root.left, maxValueSoFar);
        helper(root.right, maxValueSoFar);
        
        return count;
    }
}