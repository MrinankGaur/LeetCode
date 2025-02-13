class Solution {
    public void rotate(int[] nums, int k) {
         k = k%nums.length;
        if(nums.length==1){
            return;
        }
        for(int i =0;i<nums.length/2;i++){
            nums[i]=nums[i]^nums[nums.length-1-i];
            nums[nums.length-1-i]=nums[i]^nums[nums.length-1-i];
            nums[i]=nums[i]^nums[nums.length-1-i];
        }
        for(int i = 0;i<k/2;i++){
            int temp = nums[i];
            nums[i]=nums[k-1-i];
            nums[k-1-i]=temp;    
        }
        int j = 0;
        for(int i = k;i<(nums.length+k)/2;i++){
            int temp = nums[i];
            nums[i]=nums[nums.length-1-j];
            nums[nums.length-1-j]=temp;
            j++;    
        }
        System.gc();
    }
}