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
        // for(int[] row:dp){
        //     Arrays.fill(row,-1);
        // }
        // return f(1,len,arr,dp);
        for(int i=len;i>=1;i--){
            for(int j = i;j<=len;j++){
              int min = Integer.MAX_VALUE;
                for(int k = i;k<=j;k++){
                    int cost = arr[j+1] - arr[i-1] + dp[i][k-1] + dp[k+1][j];
                    min = Math.min(cost,min);
                }
                dp[i][j] = min;  
            }
        }
        return dp[1][len];
        
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