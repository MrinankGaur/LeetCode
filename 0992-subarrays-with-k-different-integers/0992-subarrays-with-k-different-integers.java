class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[999999];
        int l = 0;
        int res = 0;
        int distinct = 0;

        for (int r = 0; r < n; r++) {
            if (freq[nums[r]] == 0) distinct++;
            freq[nums[r]]++;

            while (distinct > k) {
                freq[nums[l]]--;
                if (freq[nums[l]] == 0) distinct--;
                l++;
            }

            res += (r - l + 1);
        }

        return res;
    }
}
