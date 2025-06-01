class Solution {
    public int rob(int[] num) {
        int n = num.length;
        if(n==0){
            return num[0];
        }
        int[] dp = new int[n];
        dp[0]=num[0];
        dp[1] = Math.max(num[0],num[1]);
         for(int i=2;i<n;i++){
            int take = num[i]+dp[i-2];
            int notTake = 0 + dp[i-1];
            dp[i]=Math.max(take,notTake);
        }
        return dp[n-1];
    }
}