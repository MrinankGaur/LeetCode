class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        int len = nums.length;
        if(len==1){
            return;
        }
        for(int i =0;i<len/2;i++){
            nums[i]=nums[i]^nums[len-1-i];
            nums[len-1-i]=nums[i]^nums[len-1-i];
            nums[i]=nums[i]^nums[len-1-i];
        }
        System.out.println(Arrays.toString(nums));
        for(int i = 0;i<k/2;i++){
            int temp = nums[i];
            nums[i]=nums[k-1-i];
            nums[k-1-i]=temp;    
        }
        System.out.println(Arrays.toString(nums));
        int j = 0;
        for(int i = k;i<(len+k)/2;i++){
            int temp = nums[i];
            nums[i]=nums[len-1-j];
            nums[len-1-j]=temp;
            j++;    
        }
    }
}