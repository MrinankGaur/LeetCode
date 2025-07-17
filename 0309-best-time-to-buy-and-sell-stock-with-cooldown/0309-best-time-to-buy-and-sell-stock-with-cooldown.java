class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] f1 = new int[2];
        int[] f2 = new int[2];
        int[] curr = new int[2];
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {

                if (buy == 1) {
                    curr[buy] = Math.max(-prices[i] + f1[0], f1[1]);
                } else {
                    curr[buy] = Math.max(prices[i] + f2[1], f1[0]);
                }
            }
            f2 = f1.clone();
            f1 = curr.clone();
        }
        return curr[1];
    }

}