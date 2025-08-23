class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count=0;
        int[] vis = new int[n];
        for(int i = 0;i<n;i++){
            if(vis[i]==0){
                count++;
                dfs(i,vis,isConnected);
            }
        }
        return count;
    }
    public void dfs(int node,int[] vis,int[][] isConnected){
        vis[node] = 1;
        for(int i = 0;i<isConnected.length;i++){
            if(isConnected[node][i]==1 && vis[i]==0){
                dfs(i,vis,isConnected);
            }
        }
    }
}