class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int[] dist = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]= 0;
        ways[0]= 1;
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int[] arr:roads){
            int u = arr[0];
            int v = arr[1];
            int t = arr[2];
            adj.get(u).add(new Pair(v,t));
            adj.get(v).add(new Pair(u,t));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.time-y.time);
        pq.add(new Pair(0,0));
        while(pq.size()!=0){
            Pair curr = pq.poll();
            int node = curr.node;
            int time = curr.time;
            if (time > dist[node]) {
                continue;
            }
            for(Pair neighbour : adj.get(node)){
                int travelTime = neighbour.time;
                int nextNode = neighbour.node;
                if(time + travelTime < dist[nextNode]){
                    dist[nextNode] = time + travelTime;
                    ways[nextNode] = ways[node];
                    pq.add(new Pair(nextNode,dist[nextNode]));
                }
                else if(time + travelTime == dist[nextNode]){
                    ways[nextNode] = (ways[nextNode]+ ways[node])%MOD;
                }
            }
            
        }
        return ways[n-1];
    }
    class Pair{
        int node,time;
        public Pair(int node,int time){
            this.node = node;
            this.time = time;
        }
    }
}