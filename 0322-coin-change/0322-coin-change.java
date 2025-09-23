class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int ans = helper(n-1,amount,coins,dp);
        return (ans==(int)1e9)?-1:ans;
    }
    public int helper(int i,int target,int[] coins,int[][] dp){
        if(i==0){
            if(target%coins[0]==0) return target/coins[0];
            return (int)1e9;

        }
        if(dp[i][target]!=-1) return dp[i][target];
        int notTake = helper(i-1,target,coins,dp);
        int take = (int)1e9;
        if(coins[i]<=target) take = 1 + helper(i,target-coins[i],coins,dp);
        return dp[i][target] = Math.min(notTake,take);
    }
}