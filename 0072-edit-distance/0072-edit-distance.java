
class Solution {
    private String word1;
    private String word2;
    private int[][] dp;

    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;

        dp = new int[word1.length()][word2.length()];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        return helper(0, 0);
    }

    private int helper(int i, int j) {
        if(i == word1.length()) return word2.length()-j;
        if(j == word2.length()) return word1.length()-i;

        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)){
            return dp[i][j] = helper(i+1, j+1);
        }

        int insert = helper(i, j+1);
        int delete = helper(i+1, j);
        int replace = helper(i+1, j+1);

        return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }
}
