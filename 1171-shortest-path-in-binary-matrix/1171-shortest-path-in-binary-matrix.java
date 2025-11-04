class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
       
        if(grid[0][0] != 0 || grid[n-1][m-1] != 0) return -1;

        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1}, 
            {1, -1}, {1, 0}, {1, 1}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        grid[0][0] = 1;

        while(!queue.isEmpty()) {
            int[] cell = queue.remove();
            int row = cell[0];
            int col = cell[1];
            int steps = cell[2];

            if(row == n-1 && col == m-1) return steps;

            for(int[] direction: directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if(newRow >=0 && newRow < n &&
                    newCol >= 0 && newCol < m &&
                    grid[newRow][newCol] == 0) {
                        grid[newRow][newCol] = 1;
                        queue.add(new int[]{newRow, newCol, steps+1});
                }
            }
        }

        return -1;
    }
}