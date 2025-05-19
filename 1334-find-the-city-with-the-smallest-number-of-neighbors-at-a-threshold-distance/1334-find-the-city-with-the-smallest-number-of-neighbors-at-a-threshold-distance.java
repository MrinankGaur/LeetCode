class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int ans = n;
        int c =n;
        int[][] dist = new int[n][n];
        for(int j = 0;j<n;j++){
            for(int i = 0;i<n;i++){
                if(i==j)dist[i][i]=0;
                dist[i][j]=(int)(1e9);
            }
        }
        for(int[] arr:edges){
            int u = arr[0];
            int v = arr[1];
            int w = arr[2];
            dist[u][v]=w;
            dist[v][u]=w;
        }
        for(int k = 0;k<n;k++){
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]); 
                }
            }
        }
        for(int i =0;i<n;i++){
            int temp = 0;
            for(int j = 0;j<n;j++){
                if(i==j)continue;
                if(dist[i][j]<=distanceThreshold)temp++;
            }
            if(temp<=c){
                c=temp;
                ans=i;
            }
        }
        return ans;

    }
}