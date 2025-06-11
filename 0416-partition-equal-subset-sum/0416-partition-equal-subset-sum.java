class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum+=i;
        }
        if(sum%2!=0){
            return false;
        }
        else{
            int target = sum/2;
            int[][] dp = new int[nums.length][target+1];
            for(int[] row: dp){
                Arrays.fill(row,-1);
            }
            return helper(nums.length-1,target,nums,dp);
        }
    }
    static Boolean helper(int index, int target,int[] arr,int[][] dp){
        if(target==0) 
            return true;
        if(index==0) 
            return arr[0]==target;
        if(dp[index][target]!=-1) 
            return (dp[index][target]==1);
        
        boolean notTake = helper(index-1,target,arr,dp);
        boolean take = false;
        if(target>=arr[index]){
            take = helper(index-1,target-arr[index],arr,dp);
        }
        
        dp[index][target] = (take || notTake) ? 1 : 0;
        
        return take || notTake;
        
    }
}