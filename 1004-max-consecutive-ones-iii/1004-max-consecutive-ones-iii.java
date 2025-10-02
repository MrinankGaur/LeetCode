class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxSize = 0;
        for(int i = 0;i<n;i++){
            int zeroes = 0;
            int size = 0;
            for(int j = i;j<n;j++){
                size++;
                if(nums[j]==0) zeroes++;
                if(zeroes>k){
                    size--;
                    break;
                };
            }
            maxSize = Math.max(size,maxSize);
        }
        return maxSize;
    }
}