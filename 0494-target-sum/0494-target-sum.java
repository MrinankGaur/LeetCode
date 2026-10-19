class Solution {
    private Map<String, Integer> dp;
    public int findTargetSumWays(int[] nums, int target) {
        dp = new HashMap<>();
        return dfs(0,target,nums);
    }
    private int dfs(int i, int target,int[] nums){
        if(i==nums.length){
            return target==0 ? 1:0;
        }
        String key = i +","+ target;
        if(dp.containsKey(key)) return dp.get(key);
        int add = dfs(i+1, target+nums[i],nums);
        int sub = dfs(i+1, target-nums[i],nums);
        dp.put(key,add+sub);
        return add + sub;
    }
}
