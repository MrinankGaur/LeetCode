class Solution {
    public int numEnclaves(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ((i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) && grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }

        for (int i[] : grid) {
            for (int j : i) {
                sum += j;
            }
        }
        return sum;
    }

    public void dfs(int g[][], int i, int j) {
        if (i < 0 || j < 0 || i >= g.length || j >= g[0].length || g[i][j] == 0) {
            return;
        }
        g[i][j] = 0;
        dfs(g, i + 1, j);
        dfs(g, i, j + 1);
        dfs(g, i - 1, j);
        dfs(g, i, j - 1);

    }
}