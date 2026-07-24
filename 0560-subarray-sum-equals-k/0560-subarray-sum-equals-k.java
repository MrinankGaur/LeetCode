class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int currSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int it:nums){
            currSum+=it;
            int diff = currSum-k;
            result += map.getOrDefault(diff,0);
            map.put(currSum,map.getOrDefault(currSum,0)+1);
        }
        return result;
    }
}