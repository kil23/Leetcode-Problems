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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while(!queue.isEmpty()) {
            int nodesInCurrentLevel = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for(int i=0; i<nodesInCurrentLevel; i++) {
                TreeNode node = queue.remove();
                currentLevel.add(node.val);

                if(node.left != null) {
                    queue.add(node.left);
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
            }

            if(level % 2 == 1) {
                Collections.reverse(currentLevel);
            }

            list.add(currentLevel);
            level++;
        }

        return list;        
    }
}