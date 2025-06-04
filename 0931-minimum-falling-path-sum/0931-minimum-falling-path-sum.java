class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        Integer dp[][] = new Integer[n][n];
        int min = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            min = Math.min(min,dfs(0,j,matrix,dp));
        }
        return min;
    }
    private int dfs(int i, int j, int[][]matrix, Integer dp[][]){
        int n = matrix.length;
        if (j < 0 || j >= n) return Integer.MAX_VALUE;
        if(i==n-1) return matrix[i][j];
        if (dp[i][j] != null) return dp[i][j];
        int down = dfs(i + 1, j, matrix, dp);
        int leftDiag = dfs(i + 1, j - 1, matrix, dp);
        int rightDiag = dfs(i + 1, j + 1, matrix, dp);
        return dp[i][j] = matrix[i][j] + Math.min(down, Math.min(leftDiag, rightDiag));
    }
}