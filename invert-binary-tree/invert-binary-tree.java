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
    
    public TreeNode invertTreeBFS(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            
            //swap using temp treenode
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }
}