class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int INF = (int)1e8;
        int[] dist = new int[n+1];
        Arrays.fill(dist,INF);
        dist[k]=0;
        for(int i = 0;i<n-1;i++){
            for(int[] time : times){
                int u = time[0];
                int v = time[1];
                int w = time[2];
                if(dist[u]!=INF && dist[u]+w<dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }
        // for(int[] time : times){
        //         int u = time[0];
        //         int v = time[1];
        //         int w = time[2];
        //         if(dist[u]!=INF && dist[u]+w<dist[v]){
        //             return -1;
        //         }
        //     }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF) {
                return -1;
            }
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}