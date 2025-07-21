class Solution {
    public ArrayList<Integer> largestDivisibleSubset(int nums[]) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        int lastIndex = 0;
        Arrays.fill(dp,1);
        int max = 1;
        for(int i = 0;i<n;i++){
            hash[i] = i;
            for(int prev = 0;prev<i;prev++){
                if(nums[i]%nums[prev]==0 && 1+dp[prev]>dp[i]){
                    dp[i] = 1+dp[prev];
                    hash[i] = prev;
                    
                }
            }
           if(dp[i]>max){
               max = dp[i];
               lastIndex = i;
           }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[lastIndex]);
        int it = 1;
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            list.add(nums[lastIndex]);
        }
        Collections.reverse(list);
        return list;
        
    }
}
