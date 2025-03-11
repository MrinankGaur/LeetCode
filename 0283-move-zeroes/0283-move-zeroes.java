class Solution {
    public void moveZeroes(int[] nums) {
        int end = nums.length-1;
        int start = 0;
        int temp = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
               nums[start++]=nums[i];
            }else{
                temp++;
            }
        }
        Arrays.fill(nums,nums.length-temp,nums.length,0);
    }
}