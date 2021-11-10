//T:O(n)
//S:O(n)

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(node.left!=null){
                    //if left node is the leaf node
                    if(node.left.left==null && node.left.right==null){
                        res+=node.left.val;
                    }
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
        }
        return res;
    }
}