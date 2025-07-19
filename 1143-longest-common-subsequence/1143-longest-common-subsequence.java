class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        // int[][] dp = new int[n+1][m+1];
        // for(int[] row:dp){
        //     Arrays.fill(row,-1);
        // }
        // return f(n,m,s1,s2,dp);
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }else{
                    curr[j]=Math.max(prev[j],curr[j-1]);
                }
            }
            prev = curr.clone();
        }
        return prev[m];
    }
    public int f(int i,int j,String s1,String s2,int[][]dp){
        if(i==0 || j==0){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            return dp[i][j] = 1 + f(i-1,j-1,s1,s2,dp);
        }
        return dp[i][j]=Math.max(f(i-1,j,s1,s2,dp),f(i,j-1,s1,s2,dp));
    }
}