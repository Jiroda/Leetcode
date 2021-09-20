class Solution {
  private int sum = 0;
  private int height = 0;

  public int maxDepth(TreeNode root) {
    if(root == null)
    return 0;
    return (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
  }

  public int deepestLeavesSum(TreeNode root) {
    height = maxDepth(root);
    return deepestSum(root, 1);
  }

  public int deepestSum(TreeNode node, int level) {
    if (node == null)
    return 0;
    if(node.left == null && node.right == null && level == height) {
    sum = sum + node.val;
    return sum;
    }
    int left = deepestSum(node.left, level+1);
    int right = deepestSum(node.right, level+1);

    return sum;
  }
}