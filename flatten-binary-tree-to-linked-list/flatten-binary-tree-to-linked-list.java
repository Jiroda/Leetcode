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
//S:O(1)
class Solution {
    public void flatten(TreeNode curr) {
        TreeNode prev = null;
        while(curr!=null){
            //Keep going till the left subtree becomes null
            if(curr.left!=null){
                //hold the curr.left in a previous pointer
                prev = curr.left;
                //move down the left subtree of the previous ptr till you reach the tail end
                while(prev.right!=null){
                    prev = prev.right;
                }
                //link the left tail and the right subtree of the current
                prev.right = curr.right;
                //set left subtree of current to its right subtree
                curr.right = curr.left;
                //set currents left to null
                curr.left = null;
            }
            //move to the next child in the right subtree of current till you flatten the whole tree
            curr = curr.right;
        }
    }
}