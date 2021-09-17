
class Solution {
    public int maxDepth(Node root) {
        if(root==null) return 0;
        return helper(root);
    }
    
    private int helper(Node root){
        if(root==null){
            return 0;
        }
        //already height is 1 if node is not null
        int maxDepth = 1;
        
        List<Node> children = root.children;
        for(Node child : children){
            maxDepth = Math.max(maxDepth, 1+ helper(child));
        }
        
        return maxDepth;
    }
}