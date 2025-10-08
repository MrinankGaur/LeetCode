class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int window = n - k;
        int sum = 0;
        for (int s : cardPoints) sum += s;
        if (window == 0) return sum;
        int windowSum = 0;
        for (int i = 0; i < window; i++) {
            windowSum += cardPoints[i];
        }

        int minWindowSum = windowSum;

        for (int i = window; i < n; i++) {
            windowSum += cardPoints[i] - cardPoints[i - window];
            minWindowSum = Math.min(minWindowSum, windowSum);
        }

        return sum - minWindowSum;
    }
}
