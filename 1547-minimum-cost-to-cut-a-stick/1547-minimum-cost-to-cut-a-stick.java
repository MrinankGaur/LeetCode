class Solution {
    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        Arrays.sort(cuts);
        int[] arr = new int[len+2];
        arr[len+1] = n;
        for(int i = 0;i<len;i++){
            arr[i+1] = cuts[i];
        }
        int[][] dp = new int[len+2][len+2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return f(1,len,arr,dp);
        
    }
    public static int f(int i,int j,int[] cuts,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = i;k<=j;k++){
            int cost = cuts[j+1] - cuts[i-1] + f(i,k-1,cuts,dp) + f(k+1,j,cuts,dp);
            min = Math.min(cost,min);
        }
        return dp[i][j] = min;

    }
}