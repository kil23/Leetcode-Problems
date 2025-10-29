class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        if(m==1 && n==1) return 0;

        boolean[][][] visited = new boolean[m][n][k+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, k});
        visited[0][0][k] = true;

        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            int row = cell[0];
            int col = cell[1];
            int steps = cell[2];
            int remaining = cell[3];

            for(int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if(newRow >=0 && newRow < m && newCol >=0 && newCol <n){
                    int newRemaining = remaining - grid[newRow][newCol];

                    if(newRemaining >= 0 && !visited[newRow][newCol][newRemaining]) {
                        if(newRow == m-1 && newCol == n-1) {
                            return steps + 1;
                        }

                        visited[newRow][newCol][newRemaining] = true;
                        queue.add(new int[]{newRow, newCol, steps + 1, newRemaining});
                    }
                }
            }
        }

        return -1;
    }
}