class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int res1=help(0,n-1,nums,dp);
        Arrays.fill(dp,-1);
        return Math.max(res1,help(1,n,nums,dp));
    }
    public int help(int i,int end,int[] nums,int[] dp){
        if(i>=end) return 0;
        if(dp[i]!=-1) return dp[i];
        return dp[i]=Math.max(help(i+1,end,nums,dp),nums[i]+help(i+2,end,nums,dp));
    }
}
