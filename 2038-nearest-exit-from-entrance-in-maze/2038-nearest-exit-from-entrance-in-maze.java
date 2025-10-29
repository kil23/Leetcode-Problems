class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.add(new int[]{entrance[0], entrance[1], 0}); 
        visited[entrance[0]][entrance[1]] = true;

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0, -1}};

        while(!queue.isEmpty()) {
            int[] cell = queue.remove();
            int row = cell[0];
            int col = cell[1];
            int steps = cell[2];

            for(int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if(newRow >= 0 && newRow < m && 
                newCol >= 0 && newCol < n && 
                maze[newRow][newCol] == '.' && 
                !visited[newRow][newCol]) {
                    if(newRow == 0 || newRow == m-1 || newCol == 0 || newCol == n-1) {
                        return steps + 1;
                    }
                    visited[newRow][newCol] = true;
                    queue.add(new int[]{newRow, newCol, steps + 1});
                }
            }
        }

        return -1;
    }
}