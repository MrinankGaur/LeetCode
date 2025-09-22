class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] vis = new int[n];
        int ans = 0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                ans++;
                dfs(i,n,isConnected,vis);
            }
        }
        return ans;
    }
    public void dfs(int i,int n,int[][] isConnected,int[]vis){
        vis[i]=1;
        for(int j = 0;j<n;j++){
            if(isConnected[i][j]==1 && vis[j]==0){
                dfs(j,n,isConnected,vis);
            }
        }
    }
}