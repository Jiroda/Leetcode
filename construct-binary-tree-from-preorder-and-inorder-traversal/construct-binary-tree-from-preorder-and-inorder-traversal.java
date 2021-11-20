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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        LinkedList<Integer> preorderList = new LinkedList<>();
        for(int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        for(int val: preorder){
            preorderList.add(val);
        }
        
        return helper(inorderMap, preorderList, 0, inorder.length-1);
        
    }
    
    private TreeNode helper(HashMap<Integer, Integer> inorderMap, LinkedList<Integer> preorderList, int start, int end){
        if(start>end){
            return null;
        }
        int rootVal = preorderList.removeFirst();
        int rootIndex = inorderMap.get(rootVal);
        
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(inorderMap, preorderList, start, rootIndex-1);
        root.right = helper(inorderMap, preorderList, rootIndex+1, end);
        return root;
    }
}