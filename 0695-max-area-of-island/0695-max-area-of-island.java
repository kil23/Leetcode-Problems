class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int max = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(max, dfs(i, j, grid, visited));
                }
            }
        }

        return max;
    }

    private int dfs(int i, int j, int[][] grid, boolean[][] visited) {
        if(i<0 || i>=grid.length || j<0 || j>= grid[i].length || grid[i][j] == 0 || visited[i][j] == true) {
            return 0;
        }
        visited[i][j] = true;

        return 1 + dfs(i+1, j, grid, visited) + dfs(i-1, j, grid, visited) + dfs(i, j+1, grid, visited) + dfs(i, j-1, grid, visited);
    }
}