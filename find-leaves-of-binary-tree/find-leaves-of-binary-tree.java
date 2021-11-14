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
    public List<List<Integer>> findLeaves(TreeNode root) {
        HashMap<Integer, List<Integer>> res = new HashMap<>();
        helper(root, res);
        List<List<Integer>> answer = new ArrayList<>();
        //Transform the map into the answer
        for(int key: res.keySet()){
            answer.add(res.get(key));
        }
        return answer;
    }
    
    private int helper(TreeNode root,  HashMap<Integer, List<Integer>> res){
        if(root==null){
            return -1;
        }
        
        int height = 1+Math.max(helper(root.left, res), helper(root.right, res));
        if(height>=0){
            res.put(height, res.getOrDefault(height, new ArrayList<>()));
            res.get(height).add(root.val);
        }
        return height;
    }
}