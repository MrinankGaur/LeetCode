class Solution {
     public int missingNumber(int[] nums) {
        int sum = 0;
        int max = 0;
        for(int i = 0;i<nums.length;i++){
            max+=i;
            sum+=nums[i];
        }
        max+=nums.length;
        return max-sum;
    }
}