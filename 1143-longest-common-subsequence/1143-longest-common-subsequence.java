class Solution {
    String s1;
    String s2;
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        this.s1 = text1;
        this.s2 = text2;
        dp = new int[s1.length()+1][s2.length()+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return helper(0,0);
    }
    private int helper(int i, int j){
        if(i==s1.length() || j==s2.length()){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=1+helper(i+1,j+1);
        }
        return dp[i][j]=Math.max(helper(i+1,j),helper(i,j+1));
    }
}