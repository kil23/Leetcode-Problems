class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        for(int row = 0; row < mat.length; row++) {
            for(int col = 0; col < mat[0].length; col++) {
                if(mat[row][col] == 0) {
                    queue.add(new int[]{row, col});
                } else {
                    mat[row][col] = -1;
                }
            }
        }

        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        while(!queue.isEmpty()) {
            int[] cell = queue.remove();
            for(int[] direction : directions) {
                int newRow = cell[0] + direction[0];
                int newCol = cell[1] + direction[1];

                if(newRow >= 0 && newRow < mat.length && newCol >= 0 && newCol < mat[0].length && mat[newRow][newCol] == -1) {
                    mat[newRow][newCol] = mat[cell[0]][cell[1]] + 1;
                    queue.add(new int[] {newRow, newCol});
                }
            }
        }

        return mat;
    }
}