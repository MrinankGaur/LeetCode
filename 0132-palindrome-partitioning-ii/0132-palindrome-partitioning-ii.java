class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        
        for(int i = n-1;i>=0;i--){
            int minCost = Integer.MAX_VALUE;
            for(int j = i;j<n;j++){
                if(isPalindrome(s,i,j)){
                    int cost = 1 + dp[j+1];
                    minCost = Math.min(minCost,cost);
                }
            }
            dp[i] = minCost;
            
        }
        return dp[0]-1;
    }
    public static int f(int i,int n,String s,int[] dp){
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];
        int minCost = Integer.MAX_VALUE;
        for(int j = i;j<n;j++){
            if(isPalindrome(s,i,j)){
                int cost = 1 + f(j+1,n,s,dp);
                minCost = Math.min(minCost,cost);
            }
        }
        return dp[i] = minCost;

    }
    public static boolean isPalindrome(String str,int start,int end){
        while(start<end){
            if(str.charAt(start++)!=str.charAt(end--)) return false;
        }
        return true;
    }
}