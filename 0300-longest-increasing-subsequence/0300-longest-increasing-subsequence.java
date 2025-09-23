class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i = 0;i<n;i++){
            for(int prev = 0;prev<i;prev++){
                if(nums[i]>nums[prev]){
                    dp[i] = Math.max(1+dp[prev],dp[i]);
                    max = Math.max(dp[i],max);
                }
            }
        }
        return max;
        
        
    }
}