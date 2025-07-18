class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        // for(int[] row: dp){
        //     Arrays.fill(row,-1);
        // }
        // return f(0,-1,nums,dp);
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];
        for(int i = n-1;i>=0;i--){
            for(int j = i-1;j>=-1;j--){
                int len = prev[j+1];
                if(j==-1 || nums[i]>nums[j]) len= Math.max(len,1 + prev[i+1]);
                curr[j+1]=len;
            }
            prev = curr.clone();
        }
        return prev[0];
    }
    public int f(int i,int j,int[] nums,int[][] dp){
        if(i ==nums.length) return 0;
        if(dp[i][j+1]!=-1) return dp[i][j+1];
        int len = f(i+1,j,nums,dp);
        if(j==-1 || nums[i]>nums[j]) len= Math.max(len,1 + f(i+1,i,nums,dp));
        return dp[i][j+1]=len;
    }

}