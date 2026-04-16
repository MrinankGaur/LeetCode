class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] temp1 = new int[n-1];
        int[] temp2 = new int[n-1];
        for(int i = 0;i<n-1;i++){
            temp1[i]= nums[i];
            temp2[i] = nums[i+1];
        }
        return Math.max(helper(temp1),helper(temp2));
        
    }
    public int helper(int[] num) {
        int n = num.length;
        if(n==0) return 0;
        if(n==1) return num[0];
        int prev2 = 0;
        int prev1 = num[0];
        for (int i = 1; i < n; i++) {
            int take = num[i];
            if(i>1)
                take+=prev2;
            int notTake = 0 + prev1;
            int curr = Math.max(take,notTake);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}