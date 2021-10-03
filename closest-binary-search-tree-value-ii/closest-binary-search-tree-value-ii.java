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
//2 iterators time: amortized O(logn + k) space: O(logn)
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        //sanity check
        if (root == null || k <= 0) {
            return result;
        }
        AscIterator ascIterator = new AscIterator(root, target);
        DescIterator descIterator = new DescIterator(root, target);
        TreeNode nextLarger= ascIterator.next();
        TreeNode nextSmaller = descIterator.next();
        for (int i = 0; i < k; i++) {
            if (nextLarger == null && nextSmaller == null) {
                return result;
            } else if (nextSmaller == null || (nextLarger != null && getCloser(nextSmaller, nextLarger, target) == nextLarger)) {
                result.add(nextLarger.val);
                nextLarger = ascIterator.next();
            } else if (nextLarger == null || (nextSmaller != null && getCloser(nextSmaller, nextLarger, target) == nextSmaller)) {
                result.add(nextSmaller.val);
                nextSmaller = descIterator.next();
            }
        }
        return result;
    }
    private TreeNode getCloser(TreeNode nextSmaller, TreeNode nextLarger, double target) {
        if (Math.abs(nextSmaller.val - target) <= Math.abs(nextLarger.val - target)) {
            return nextSmaller;
        }
        return nextLarger;
    }
    static class AscIterator {// smallestLarger
        private Deque<TreeNode> stack;
        AscIterator(TreeNode root, double target) {
            stack = new ArrayDeque<>();
            while (root != null) {
                if (root.val > target) {
                    stack.offerFirst(root);
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
        }
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        public TreeNode next() {
            if (!hasNext()) {
                return null;
            }
            TreeNode cur = stack.pollFirst();
            TreeNode result = cur;
            cur = cur.right;
            while (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            }
            return result;
        }
    }
    static class DescIterator {//largestSmaller or equals
        private Deque<TreeNode> stack;
        DescIterator(TreeNode root, double target) {
            stack = new ArrayDeque<>();
            while (root != null) {
                if (root.val <= target) {
                    stack.offerFirst(root);
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
        }
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        public TreeNode next() {
            if (!hasNext()) {
                return null;
            }
            TreeNode cur = stack.pollFirst();
            TreeNode result = cur;
            cur = cur.left;
            while (cur != null) {
                stack.offerFirst(cur);
                cur = cur.right;
            }
            return result;
        }
    }
}