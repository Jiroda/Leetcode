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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        HashMap<TreeNode, TreeNode> nodeToParentMap = new HashMap<>();
        findParents(root, null, nodeToParentMap);
        //BFS from the target
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        int level =0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode currNode = queue.poll();
                TreeNode parent = nodeToParentMap.get(currNode);
                
                if(level==k){
                    result.add(currNode.val);
                }
                
                //Parent
                if(parent!=null && !visited.contains(parent)){
                    queue.offer(parent);
                    visited.add(parent);
                }
                
                //left
                if(currNode.left!=null){
                   if(!visited.contains(currNode.left)){
                       queue.offer(currNode.left);
                       visited.add(currNode.left);
                   }
                }
                
                //right
                if(currNode.right!=null){
                   if(!visited.contains(currNode.right)){
                       queue.offer(currNode.right);
                       visited.add(currNode.right);
                   }
                }
            }
            level++;
        }
        return result;
    }
    
    private void findParents(TreeNode root, TreeNode parent, HashMap<TreeNode, TreeNode> nodeToParentMap){
        if(root==null){
            return;
        }
        nodeToParentMap.put(root, parent);
        findParents(root.left, root, nodeToParentMap);
        findParents(root.right, root, nodeToParentMap);
    }
    
}