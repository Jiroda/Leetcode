//T:O(n)
//S:O(n)

class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Integer pre = null;
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre!=null){
                if(root.val<=pre){
                    return false;
                }
            }
            pre = root.val;
            root = root.right;
        }
        
        return true;
    }
}