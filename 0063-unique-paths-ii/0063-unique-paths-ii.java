class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 ||
            obstacleGrid[row - 1][col - 1] == 1) {
            return 0;
        }
        dp = new int[row][col];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(row-1,col-1,obstacleGrid); 
    }
    public int helper(int row, int col, int[][] grid){
        if(row==0 && col==0) return 1;
        if(dp[row][col]!=-1) return dp[row][col];
        int left = 0;
        if(row-1>=0 && grid[row-1][col]==0) left = helper(row-1,col,grid);
        int right = 0;
        if(col-1>=0 && grid[row][col-1]==0) right = helper(row,col-1,grid);
        return dp[row][col] = left + right; 
    }
}