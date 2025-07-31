class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int pos = n-1;
        for(int i = n-2;i>=0;i--){
            if(nums[i]>=(pos-i)){
                pos = i;
            }
        }
        return pos == 0;
    }
}