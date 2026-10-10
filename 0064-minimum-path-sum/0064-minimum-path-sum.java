class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        dp = new int[row][col];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }

        return helper(row-1,col-1,grid);
    }
    public int helper(int row, int col,int[][] grid){
        if(row==0 && col==0) return grid[row][col];
        if(dp[row][col]!=-1) return dp[row][col];
        int up = Integer.MAX_VALUE;
        if(row-1>=0) up = grid[row][col] + helper(row-1,col,grid);

        int left = Integer.MAX_VALUE;
        if(col-1>=0) left = grid[row][col] + helper(row,col-1,grid);    
        
        return dp[row][col] = Math.min(left,up);

    }
}