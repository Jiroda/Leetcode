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
        int ans =0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, Integer.MIN_VALUE));
        
        while(!queue.isEmpty()){
            int size =queue.size();
            for(int i=0; i<size; i++){
                Pair curr = queue.poll();
                if(curr.maxSofar<= curr.node.val){
                    ans++;
                }
                
                if(curr.node.right!=null){
                    queue.offer(new Pair(curr.node.right, Math.max(curr.node.val, curr.maxSofar)));
                }
                
                if(curr.node.left!=null){
                   queue.offer(new Pair(curr.node.left, Math.max(curr.node.val, curr.maxSofar))); 
                }
            }
        }
        
        
        return ans;
    }
}

class Pair{
    TreeNode node;
    int maxSofar; 
    
    public Pair(TreeNode node, int maxSoFar){
        this.node = node;
        this.maxSofar = maxSoFar;
    }
}