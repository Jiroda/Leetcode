//T:O(n)
//S:O(h)

class Solution {
    public TreeNode invertTree(TreeNode root) {
        return helper(root);
    }
    
    private TreeNode helper(TreeNode root){
        //Base Case
        if(root==null){
            return root;
        }
        
        TreeNode leftSubtree = helper(root.left);
        TreeNode rightSubtree = helper(root.right);
        
        //swap
        root.left = rightSubtree;
        root.right = leftSubtree;
        
        return root;
    }
}