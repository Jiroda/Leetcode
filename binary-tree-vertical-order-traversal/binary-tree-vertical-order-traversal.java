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
    public List<List<Integer>> verticalOrder(TreeNode root) {
    	//Base cases 
        if(root==null){
        	return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> columnIndexToNodeMap = new HashMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> coordQueue = new LinkedList<>();
        nodeQueue.offer(root);
        coordQueue.offer(0);
        while(!nodeQueue.isEmpty()){
        	int size = nodeQueue.size();
            for(int i=0 ; i<size; i++){
              	TreeNode polledNode  = nodeQueue.poll();
                int column = coordQueue.poll();
                
    			//map the polledNode to the column index
                if(!columnIndexToNodeMap.containsKey(column)){
                    columnIndexToNodeMap.put(column, new ArrayList<>());
                }
                columnIndexToNodeMap.get(column).add(polledNode.val);
                

                if(polledNode.left!=null){
                	nodeQueue.offer(polledNode.left);
                    coordQueue.offer(column-1);
                }
                if(polledNode.right!=null){
                	nodeQueue.offer(polledNode.right);
                    coordQueue.offer(column+1);
                }
            }
        }
        
        
        //Build the end result
        List<Integer> sortedKeys = new ArrayList<Integer>(columnIndexToNodeMap.keySet());
        Collections.sort(sortedKeys);
        for(int k : sortedKeys) {
          result.add(columnIndexToNodeMap.get(k));
        }
        return result;
    }
}