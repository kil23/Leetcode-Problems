/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        buildGraph(root, null, graph);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);

        int distance = 0;

        while(!queue.isEmpty()) {
            if(distance == k) break;

            int nodesInCurrentLevel = queue.size();
            for(int i=0; i<nodesInCurrentLevel; i++) {
                TreeNode node = queue.remove();
                for(TreeNode neighbor : graph.get(node)) {
                    if(!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            distance++;
        }

        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            res.add(queue.remove().val);
        }

        return res;
    }

    private void buildGraph(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> graph) {
        if(node == null) return;
        graph.putIfAbsent(node, new ArrayList<>());
        if(parent != null) {
            graph.get(node).add(parent);
            graph.get(parent).add(node);
        }
        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }
}