class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
       int ans = 0;
        int temp = 0;

        for(int i : nums){
            if(i == 1){
                temp++;
            }
            else{
                ans = Math.max(ans,temp);
                temp = 0;
            }
        }

        return Math.max(temp,ans);
    }
}