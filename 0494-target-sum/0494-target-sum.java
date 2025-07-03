import java.util.Arrays;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        if ((totalSum + target) % 2 != 0 || totalSum < Math.abs(target)) return 0;

        int subsetSum = (totalSum + target) / 2;

        int[][] dp = new int[nums.length][subsetSum + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return countSubsets(nums.length - 1, subsetSum, nums, dp);
    }

    private int countSubsets(int index, int sum, int[] nums, int[][] dp) {
        if (index == 0) {
            if (sum == 0 && nums[0] == 0) return 2;  // +0 and -0 are both valid
            if (sum == 0 || sum == nums[0]) return 1;
            return 0;
        }

        if (dp[index][sum] != -1) return dp[index][sum];

        int notPick = countSubsets(index - 1, sum, nums, dp);
        int pick = 0;
        if (nums[index] <= sum)
            pick = countSubsets(index - 1, sum - nums[index], nums, dp);

        return dp[index][sum] = pick + notPick;
    }
}
