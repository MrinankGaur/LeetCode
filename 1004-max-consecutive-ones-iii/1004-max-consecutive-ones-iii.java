class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;
        int l= 0,r = 0;
        int zeroes = 0;
        while(r<n){
            if(nums[r]==0) zeroes++;
            if(zeroes>k){
                if(nums[l]==0)zeroes--;
                l++;
            }
            else{
                maxLen = Math.max(maxLen,r-l+1);
            }
            
            r++;
        }
        return maxLen;
    }
}