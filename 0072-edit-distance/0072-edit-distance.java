class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return f(n1,n2,word1,word2,dp);
    }
    public int f(int index1,int index2,String s1,String s2,int[][] dp){
        if(index1==0){
            return index2;
        }
        if(index2==0){
            return index1;
        }
        if(dp[index1][index2]!=-1) return dp[index1][index2];
        if(s1.charAt(index1-1)==s2.charAt(index2-1)){
            return dp[index1][index2] = 0 + f(index1-1,index2-1,s1,s2,dp);
        }
        return dp[index1][index2] = Math.min(1+ f(index1,index2-1,s1,s2,dp),Math.min(1+ f(index1-1,index2,s1,s2,dp),1+ f(index1-1,index2-1,s1,s2,dp)));
    }
}