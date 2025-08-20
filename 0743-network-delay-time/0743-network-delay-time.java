class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr:times){
            int u = arr[0]-1;
            int v = arr[1]-1;
            int d = arr[2];
            adj.get(u).add(new Pair(v,d));
        }
        int min = Integer.MIN_VALUE;
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->Integer.compare(x.second,y.second));
        pq.offer(new Pair(k-1,0));
        dist[k-1] = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.first;
            int time = curr.second;
            if(time>dist[node]) continue;
            for(Pair it: adj.get(node)){
                int next = it.first;
                int t = time + it.second;
                if(t<dist[next]){
                    dist[next] = t;
                    pq.offer(new Pair(next,t));
                }
            }
        }
        int ans = 0;
        for(int d:dist){
            if(d==Integer.MAX_VALUE) return -1;
            ans = Math.max(d,ans);
        }
        return ans;
    }
}

class Pair{
    int first,second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}