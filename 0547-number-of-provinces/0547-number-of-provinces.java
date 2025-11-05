class Solution {
    public int findCircleNum(int[][] isConnected) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i=0; i<isConnected.length; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
            for(int j=i+1; j<isConnected[i].length; j++) {
                graph.putIfAbsent(j, new ArrayList<>());
                if(isConnected[i][j] == 1) {
                    graph.get(j).add(i);
                    graph.get(i).add(j);
                }
            }
        }

        int provinces = 0;
        Set<Integer> visited = new HashSet<>();

        for(int node : graph.keySet()) {
            if(!visited.contains(node)) {
                provinces++;
                dfs(node, graph, visited);
            }
        }

        return provinces;
    }

    private void dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if(visited.contains(node)) return;

        visited.add(node);

        for(int neighbor : graph.get(node)) {
            dfs(neighbor, graph, visited);
        }
    }
}