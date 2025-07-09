class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        // for(int[] row:dp){
        //     Arrays.fill(row,-1);
        // }
        // return helper(n-1,amount,dp,coins);
        for(int i = 0;i<=amount;i++){
            dp[0][i] = (i%coins[0]==0)?1:0;
        }

        for(int i = 1;i<n;i++){
            for(int t = 0;t<=amount;t++){
                int notTake = dp[i-1][t];
                int take = 0;
                    if(coins[i]<=t){
                        take = dp[i][t-coins[i]];
                    }
                    dp[i][t] = notTake + take;
            }
        }
        return dp[n-1][amount];

    }
    // memoization;
    // public int helper(int index,int amount,int[][] dp, int[] coins){
    //     if(index==0){
    //         if(amount%coins[index]==0)
    //             return 1;
    //         else
    //             return 0;
    //     }
    //     if(dp[index][amount]!=-1)
    //         return dp[index][amount];
    //     int notTake = helper(index-1, amount,dp,coins);
    //     int take = 0;
    //     if(coins[index]<=amount){
    //         take = helper(index,amount-coins[index],dp,coins);
    //     }
    //     return dp[index][amount] = notTake + take;
    // }
}