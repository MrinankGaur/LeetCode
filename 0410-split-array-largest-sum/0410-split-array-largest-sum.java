class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        if(k>n) return -1;
        int low = 0;
        int high = 0;
        for(int num:nums){
            low = Math.max(low,num);
            high += num;
        }

        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int limit = count(nums,mid);
            if(limit<=k){
                ans = mid;
                high = mid-1;
            }else{
                low = mid +1;
            }
        }
        return ans;
    }
    public int count(int[] nums, int limit){
        int res = 1;
        int sum = 0;
        for(int num:nums){
            if(sum+num<=limit){
                sum+=num;
            }else{
                res++;
                sum = num;
            }
        }
        return res;
    }
}