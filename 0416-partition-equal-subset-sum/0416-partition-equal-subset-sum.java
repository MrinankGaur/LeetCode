class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int it: nums){
            sum+=it;
        }
        if(sum%2!=0) return false;
        int target=sum/2;
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        dp[0][0] = 1;
        if(nums[0]==target) dp[0][nums[0]] =1;
        for(int i = 1;i<n;i++){
            for(int t = 0;t<=target;t++){
                boolean notTake = dp[i-1][t]==1;
                boolean take = false;
                if(nums[i]<=t) take = dp[i-1][t-nums[i]]==1;
                dp[i][t] = take || notTake ? 1 : 0;
            }
        }
        return dp[n-1][target]==1;
        
    }
}