//Time complexity: O(n)
//Space Complexity: O(n)

class Solution {
    public int maxDepth(Node root) {
        if(root==null) return 0;
        return helper(root);
    }
    
    private int helper(Node root){
        if(root==null){
            return 0;
        }
        int maxDepth = 0;
        List<Node> children = root.children;
        for(Node child : children){
            maxDepth = Math.max(maxDepth, helper(child));
        }
        
        return maxDepth+1; //+1 is to included the current node on which the recursion is run
    }
}