class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int[] row:dp){
            for(int i = 0;i<=n2;i++){
                row[i] = -1;
            }
        }
        return helper(n1,n2,text1,text2,dp);
        // for(int i = 0;i<n2;i++){
        //     if(text1.charAt(0)==text2.charAt(i)){
        //         dp[0][i] = 1;
        //     }
        // }
    }
    public int helper(int index1, int index2,String text1, String text2,int[][] dp){
        if(index1 == 0 || index2 == 0)
            return 0;
        if(dp[index1][index2]!=-1)
            return dp[index1][index2];
        if(text1.charAt(index1-1)==text2.charAt(index2-1)){
            return dp[index1][index2] = 1 + helper(index1-1,index2-1,text1,text2,dp);
        }
        return dp[index1][index2] = Math.max(helper(index1,index2-1,text1,text2,dp),helper(index1-1,index2,text1,text2,dp));
    }
}