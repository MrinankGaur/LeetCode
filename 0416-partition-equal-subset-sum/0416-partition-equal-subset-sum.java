class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int it: nums){
            sum+=it;
        }
        int target=sum/2;
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        for(int[] row: dp) Arrays.fill(row,-1);
        if(sum%2!=0) return false;
        return f(nums.length-1,target,nums,dp);
        
    }
    public boolean f(int i,int target,int[] nums, int[][] dp){
        if(i==0){
            if(target==0){
                return true;
            }
            return false;
        }
        if(dp[i][target]!=-1) return dp[i][target]==1;
        boolean notTake = f(i-1,target,nums,dp);
        boolean take = false;
        if(nums[i]<=target) take = f(i-1,target-nums[i],nums,dp);
        dp[i][target] = take || notTake ? 1 : 0;
        return take || notTake;
    }
}