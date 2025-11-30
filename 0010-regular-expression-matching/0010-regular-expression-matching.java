class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0,j=0;
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(s,p,i,j,dp); 
    }
     private boolean helper(String s, String p, int i, int j, int[][] dp) {
        if (dp[i][j] != -1) return dp[i][j] == 1;

        int n = s.length();
        int m = p.length();
        boolean ans;

        if (i == n && j == m) {
            ans = true;
        } else if (j == m) {
            // pattern finished but string not
            ans = false;
        } else {
            // only check p.charAt(j) when i < n
            boolean match = (i < n) && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j));

            if (j + 1 < m && p.charAt(j + 1) == '*') {
                // skip "x*" or use one match and stay on same pattern j
                ans = helper(s, p, i, j + 2, dp) || (match && helper(s, p, i + 1, j, dp));
            } else {
                ans = match && helper(s, p, i + 1, j + 1, dp);
            }
        }

        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
}