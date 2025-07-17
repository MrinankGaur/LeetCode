class Solution {
    public int maxProfit(int[] prices,int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return f(0,1,prices,dp,fee);
        // int[] prev = new int[2];
        // int[] curr = new int[2];
        // for (int i = n - 1; i >= 0; i--) {
        //     for (int buy = 0; buy <= 1; buy++) {

        //         if (buy == 1) {
        //             curr[buy] = Math.max(-prices[i] + prev[ 0],prev[1]);
        //         } else {
        //             curr[buy] = Math.max(prices[i] + prev[1], prev[ 0]);
        //         }
        //     }
        //     prev = curr;
        // }
        // return prev[1];

    }

    public int f(int i, int buy, int[] prices, int[][] dp,int fee) {
        if (i == prices.length) {
            return 0;
        }
        if (dp[i][buy] != -1)
            return dp[i][buy];
        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-prices[i] + f(i + 1, 0, prices, dp,fee),
                    f(i + 1, 1, prices, dp,fee));
        } else {
            profit = Math.max(prices[i] + f(i + 1, 1, prices, dp,fee)-fee,
                    f(i + 1, 0, prices, dp,fee));
        }
        return dp[i][buy] = profit;
    }

}