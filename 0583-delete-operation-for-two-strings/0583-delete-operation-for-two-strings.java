class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        //int[][] dp = new int[n1+1][n2+1];
        int[] prev = new int[n2+1];
        int[] curr = new int[n2+1];
        // for(int[] row:dp){
        //     Arrays.fill(row,-1);
        // }
        // return n1 + n2 - (2*helper(n1,n2,word1,word2,dp));
        for(int index1 = 1;index1<=n1;index1++){
            for(int index2 = 1;index2<=n2;index2++){
                if(word1.charAt(index1-1)==word2.charAt(index2-1)){
                    curr[index2] = 1 + prev[index2-1];
                }
                else{
                    curr[index2] = Math.max(curr[index2-1],prev[index2]);
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        } 
        return n1 + n2 - (2*prev[n2]);      
    }
    // Memoization:- 
    //  
    // public int helper(int index1,int index2, String s1, String s2, int[][] dp){
    //     if(index1 ==0 || index2 == 0) return 0;
    //     if(dp[index1][index2]!=-1) return dp[index1][index2];
    //     if(s1.charAt(index1-1)==s2.charAt(index2-1)){
    //         return dp[index1][index2] = 1 + helper(index1-1,index2-1,s1,s2,dp);
    //     }
    //     return dp[index1][index2] = Math.max(helper(index1,index2-1,s1,s2,dp),helper(index1-1,index2,s1,s2,dp));
    // }
}