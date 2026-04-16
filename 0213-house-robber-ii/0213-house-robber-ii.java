class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        return Math.max(
            help2(0, n - 1, nums),
            help2(1, n, nums)
        );
    }

    public static int help2(int start, int end, int[] nums) {
        int prev2 = 0;
        int prev1 = 0; 
        for (int i = start; i < end; i++) {
            int take = nums[i] + prev2;
            int notTake = prev1;
            int curr = Math.max(take, notTake);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}