class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
         return helper(nums,goal)-helper(nums,goal-1);
    }
    private int helper(int[] nums,int goal){
        if(goal<0) return 0;
        int n = nums.length;
        int l = 0,r=0;
        int ways = 0;
        int sum = 0;
        while(r<n){
            sum += nums[r];
            while(sum>goal){
                sum-=nums[l++];
            }
            ways += r-l+1;
            r++;
        }
        return ways;
    }
}