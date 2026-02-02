class Solution {
    public int numIslands(char[][] grid) {
    //     int n = grid.length;
    //     int m = grid[0].length;

    //     int islands = 0;
    //     for(int i=0; i<n; i++) {
    //         for(int j=0; j<m; j++) {
    //             if(grid[i][j] == '1') {
    //                 islands++;
    //                 dfs(i, j, grid);
    //             }
    //         }
    //     }

    //     return islands;
    // }

    // private void dfs(int i, int j, char[][] grid) {
    //     if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;

    //     grid[i][j] = '0';

    //     dfs(i+1, j, grid);
    //     dfs(i-1, j, grid);
    //     dfs(i, j+1, grid);
    //     dfs(i, j-1, grid);

        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    callbfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void callbfs(char[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == '0') return;

        grid[i][j] = '0';
        callbfs(grid, i+1, j);
        callbfs(grid, i-1, j);
        callbfs(grid, i, j+1);
        callbfs(grid, i, j-1);
    }
}