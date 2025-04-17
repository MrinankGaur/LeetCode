class Pair {
    int first; //node
    int second; //edge weight or distance
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //k is basically the source node then
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int time[]: times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adj.get(u-1).add(new int[]{v-1, w});
        }
        int []dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1]=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> a.second - b.second);
        pq.add(new Pair(k-1, 0));
        while(!pq.isEmpty()) {
            Pair top = pq.poll();
            int dis = top.second;
            int node = top.first;
            for(int neighbour[] : adj.get(node)) {
                int adjNode = neighbour[0];
                int edW = neighbour[1];
                if(dis+edW<dist[adjNode]) {
                    dist[adjNode]=dis+edW;
                    pq.add(new Pair(adjNode, dis+edW));
                }
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++) {
            if(dist[i]==Integer.MAX_VALUE) {
                    return -1;
            }
            ans=Math.max(ans, dist[i]);
        }
        return ans;
    }
}