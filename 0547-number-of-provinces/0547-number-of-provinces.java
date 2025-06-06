//class Solution {
    // public int findCircleNum(int[][] isConnected) {
    //     int count = 0;
    //     int V = isConnected.length;
    //     ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    //     for(int i = 0;i<V;i++){
    //         adj.add(new ArrayList<Integer>());
    //     }
    //     for(int i = 0;i<V;i++){
    //         for(int j =0;j<V;j++){
    //             if(isConnected[i][j]==1 && i!=j){
    //                 adj.get(i).add(j);
    //                 adj.get(j).add(i);
    //             }
    //         }
    //     }
    //     int[] vis = new int[V+1];
    //     for(int i = 0;i<V;i++){
    //         if(vis[i]==0){
    //             count++;
    //             DFS(i,vis,adj);
    //         }
    //     }
    //     return count;

    // }
    // private static void DFS(int node,int[] vis, ArrayList<ArrayList<Integer>> adj){
    //     vis[node] = 1;
    //     for(Integer i: adj.get(node)){
    //         if(vis[i]==0){
    //             DFS(i,vis,adj);
    //         }
    //     }
    // }
//}    
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        int provinces = 0;
        int[] vis = new int[cities+1];
        for(int i = 1; i <= cities; i++) {
            if(vis[i] == 0) {
                provinces++;
                dfs(i, vis, isConnected);
            }
        }
        return provinces;
    }

    private void dfs(int node, int[] vis, int[][] isConnected) {
        vis[node] = 1;
        for (int i = 1; i <= isConnected.length; i++) {
            if(isConnected[node-1][i-1] == 1 && vis[i] == 0) {
                dfs(i, vis, isConnected);
            } 
        }
    }
}