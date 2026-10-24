class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adj.get(u).add(new int[]{v,w});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.offer(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];
            if(d>dist[node]) continue;
            for(int[] nei : adj.get(node)){
                int next = nei[0];
                int nd = nei[1];
                if(nd+d<dist[next]){
                    dist[next]=d+nd;
                    pq.offer(new int[]{next,dist[next]});
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1;i<=n;i++){
            max = Math.max(max,dist[i]);
        }
        return max==Integer.MAX_VALUE ? -1:max;


    }
}