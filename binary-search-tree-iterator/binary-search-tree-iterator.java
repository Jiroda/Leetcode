//T:next() is O(n) in worst case, however its amortized O(1), hasNext() is O(1)
//S:O(n)

class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode result = stack.pop();
        TreeNode temp = result.right;
        while(temp!=null){
            stack.push(temp);
            temp = temp.left;
        }
        return result.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */