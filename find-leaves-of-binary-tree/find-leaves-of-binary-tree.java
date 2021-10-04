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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leafLists = new ArrayList<>();
        if (root == null) {
            return leafLists;
        }

        List<Integer> rootAsLeafList = new ArrayList<>();
        while ((root.left != null) || (root.right != null)) {
            leafLists.add(this.removeAndCollectLeaves(root));
        }
        rootAsLeafList.add(root.val);
        root = null;
        leafLists.add(rootAsLeafList);
        return leafLists;
    }

    private List<Integer> removeAndCollectLeaves(TreeNode root) {
        List<Integer> leafValues = new ArrayList<>();
        Deque<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.addLast(root);
        while (nodeQ.peekFirst() != null) {
            TreeNode currentNode = nodeQ.pollFirst();
            TreeNode leftChild = currentNode.left;
            TreeNode rightChild = currentNode.right;

            if (leftChild != null) {
                if (this.isLeafNode(leftChild)) {
                    leafValues.add(leftChild.val);
                    currentNode.left = null;
                } else {
                    nodeQ.add(leftChild);
                }
            }
            if (rightChild != null) {
                if (this.isLeafNode(rightChild)) {
                    leafValues.add(rightChild.val);
                    currentNode.right = null;
                } else {
                    nodeQ.add(rightChild);
                }
            }
        }
        return leafValues;
    }

    boolean isLeafNode(TreeNode node) {
        return (node.left == null) && (node.right == null);
    }
}