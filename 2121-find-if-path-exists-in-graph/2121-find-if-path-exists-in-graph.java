class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        return dfs(source, destination, graph, visited);
    }

    private boolean dfs(int current, int destination, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if(current == destination) {
            return true;
        }

        if(visited.contains(current)) {
            return false;
        }

        visited.add(current);

        for(int neighbor : graph.get(current)) {
            if(dfs(neighbor, destination, graph, visited)) {
                return true;
            }
        }

        return false;
    }
}