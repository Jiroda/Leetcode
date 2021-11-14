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
    public boolean isCompleteTree(TreeNode root) {
        return helper(root);
    }
    
    private boolean helper(TreeNode node){
        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(-1, 0, false, node));
        int indexCounter=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Pair currNode = queue.poll();
                if(currNode.currentIndex!=indexCounter){
                    return false;
                }
                if(currNode.node.left!=null){
                    queue.add(new Pair(currNode.currentIndex, 2*(currNode.currentIndex)+1, true, currNode.node.left));
                }
                if(currNode.node.right!=null){
                    queue.add(new Pair(currNode.currentIndex, 2*(currNode.currentIndex)+2, false, currNode.node.right));
                }
                indexCounter++;
            }
        }
        return true;
    }
}


class Pair{
    int parentIndex;
    int currentIndex;
    boolean isLeftChild;
    TreeNode node;
    public Pair(int parentIndex, int currentIndex, boolean isLeftChild, TreeNode node){
        this.currentIndex = currentIndex;
        this.parentIndex = parentIndex;
        this.isLeftChild = isLeftChild;
        this.node = node;
    }
}
