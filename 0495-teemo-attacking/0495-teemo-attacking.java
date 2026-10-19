class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int t = 0;
        int n = timeSeries.length;
        for(int i = 0; i < n - 1; i++){
            t += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        return t + duration;
    }
}