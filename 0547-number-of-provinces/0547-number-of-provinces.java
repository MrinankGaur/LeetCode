class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count=0;
        int[] vis = new int[n+1];
        for(int i = 1;i<=n;i++){
            if(vis[i]==0){
                count++;
                dfs(i,vis,isConnected);
            }
        }
        return count;
    }
    public void dfs(int node,int[] vis,int[][] isConnected){
        vis[node] = 1;
        for(int i = 1;i<=isConnected.length;i++){
            if(isConnected[node-1][i-1]==1 && vis[i]==0){
                dfs(i,vis,isConnected);
            }
        }
    }
    //  private void dfs(int node, int[] vis, int[][] isConnected) {
    //     vis[node] = 1;
    //     for (int i = 1; i <= isConnected.length; i++) {
    //         if(isConnected[node-1][i-1] == 1 && vis[i] == 0) {
    //             dfs(i, vis, isConnected);
    //         } 
    //     }
    // }
    
}