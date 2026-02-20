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
    public int rob(TreeNode root) {
        int[] res = dfs(root);

        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root) {
        if(root == null) {
            return new int[2];
        }

        int[] leftTree = dfs(root.left);
        int[] rightTree = dfs(root.right);

        int robCurr = root.val + leftTree[1] + rightTree[1];

        int skipCurr = Math.max(leftTree[0], leftTree[1]) + Math.max(rightTree[0], rightTree[1]);

        return new int[]{robCurr, skipCurr};
    }
}