class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] vis = new int[graph.length];
        Arrays.fill(vis,-1);
        for(int i = 0;i<graph.length;i++){
            if(vis[i]==-1){
                if(dfs(i,0,vis,graph)==false) return false;
            }
        }
        return true;
    }
    private boolean dfs(int node,int col, int[] vis,int[][] graph){
        
        vis[node]=col;
        for(int i:graph[node]){
            if(vis[i]==-1){
                if(dfs(i,1-col,vis,graph)==false)return false;
            }
            else if(vis[i]==col){
                return false;
            }
        }
        return true;
    }
}