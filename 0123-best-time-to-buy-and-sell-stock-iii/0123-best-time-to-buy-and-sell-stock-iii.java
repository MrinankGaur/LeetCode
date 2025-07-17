class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int dp[][][] = new int[n + 1][2][3];
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int i = 1; i <= 2; i++) {
                    if (buy == 1) {
                        dp[idx][buy][i] = Math.max((-arr[idx] + dp[idx + 1][0][i]), dp[idx + 1][1][i]);
                    } else {
                        dp[idx][buy][i] = Math.max((arr[idx] + dp[idx + 1][1][i - 1]), dp[idx + 1][0][i]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }

    int f(int idx, int buy, int k, int[] arr, Integer[][][] dp) {
        if (k == 0 || idx == arr.length) {
            return 0;
        }
        if (dp[idx][buy][k] != null) {
            return dp[idx][buy][k];
        }
        if (buy == 1) {
            return dp[idx][buy][k] = Math.max((-arr[idx] + f(idx + 1, 0, k, arr, dp)), f(idx + 1, 1, k, arr, dp));
        }
        return dp[idx][buy][k] = Math.max(f(idx + 1, 0, k, arr, dp), (arr[idx] + f(idx + 1, 1, k - 1, arr, dp)));
    }
}