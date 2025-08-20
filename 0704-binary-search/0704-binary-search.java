class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        return bs(0,n-1,target,nums);
    }
    public int bs(int start,int end,int target,int[] nums){
        if(start>end) return -1;
        int mid = start + (end-start)/2;
        if(nums[mid] == target) return mid;
        if(nums[mid]>target) return bs(start,mid-1,target,nums);
        return bs(mid+1,end,target,nums);
    }
}