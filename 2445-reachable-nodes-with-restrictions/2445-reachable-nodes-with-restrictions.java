class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> restrictedSet = new HashSet<>();
        for(int r: restricted) {
            restrictedSet.add(r);
        }

        Set<Integer> visited = new HashSet<>();
        return dfs(0, graph, visited, restrictedSet);
    }

    private int dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited, Set<Integer> restrictedSet) {
        if(visited.contains(node) || restrictedSet.contains(node)) {
            return 0;
        }

        visited.add(node);
        int count = 1;

        for(int neighbor: graph.get(node)) {
            count += dfs(neighbor, graph, visited, restrictedSet);
        }

        return count;
    }
}