
import java.util.Arrays;

class Solution {
    private int[] coins;
    private int[][] dp;

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        int n = coins.length;

        dp = new int[n][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = helper(0, amount);

        return ans >= 1_000_000_000 ? -1 : ans;
    }

    public int helper(int i, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (i == coins.length) {
            return 1_000_000_000;
        }

        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }

        int notTake = helper(i + 1, amount);

        int take = 1_000_000_000;

        if (coins[i] <= amount) {
            take = 1 + helper(i, amount - coins[i]);
        }

        return dp[i][amount] = Math.min(take, notTake);
    }
}
