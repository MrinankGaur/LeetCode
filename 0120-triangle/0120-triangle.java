class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(0,0,dp,triangle);
    }
    public int helper(int i, int j,int[][] dp, List<List<Integer>> triangle){
        if(i == triangle.size()-1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int d = triangle.get(i).get(j) + helper(i+1,j,dp,triangle);
        int dg = triangle.get(i).get(j) + helper(i+1,j+1,dp,triangle);
        return dp[i][j] = Math.min(d,dg);
    }
}