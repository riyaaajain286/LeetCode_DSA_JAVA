class Solution {
    public int numIslands(char[][] grid) {
      int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If land ('1') and not yet visited, it's a new island
                if (grid[i][j] == '1' && vis[i][j] == 0) {
                    count++;
                    dfs(i, j, grid, vis);
                }
            }
        }

        return count;
    }

    private void dfs(int row, int col, char[][] grid, int[][] vis) {
        int n = grid.length;
        int m = grid[0].length;

        vis[row][col] = 1;

        // 4 possible directions: up, right, down, left
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            // Check valid coordinates and unvisited land
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                dfs(nrow, ncol, grid, vis);
            }
        }
    }  
    
}