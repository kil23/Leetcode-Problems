class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int components = 0;
        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<n; i++) {
            if(!visited.contains(i)) {
                components++;
                dfs(i, graph, visited);
            }
        }

        return components;
    }

    private void dfs(int i, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if(visited.contains(i)) return;

        visited.add(i);
        for(int neighbor : graph.getOrDefault(i, new ArrayList<>())) {
            dfs(neighbor, graph, visited);
        }
    }
}