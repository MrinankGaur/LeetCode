class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        for(int i = 0;i<n;i++){
            int t = target-nums[i];
            for(int j = 0;j<n && j!= i;j++){
                if(nums[j]==t){
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }
}