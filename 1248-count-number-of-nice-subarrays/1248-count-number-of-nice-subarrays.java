class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }
    public int helper(int[] nums, int k) {
        int n = nums.length;
        int l = 0,r=0;
        int oddCount = 0;
        int ways =0;
        while(r<n){
            if(nums[r]%2==1) oddCount++;
            while(oddCount>k){
                oddCount = (nums[l]%2==1) ? oddCount-1 : oddCount;
                l = l + 1;
            }
            ways += r-l+1;
            r++;
        }
        return ways;
    }
}