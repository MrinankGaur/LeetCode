class Solution {

    private class Pair{
        int first;
        long second;

        public Pair(int first,long second){
            this.first = first;
            this.second = second;
        }
    }

    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] arr:roads){
            int u = arr[0];
            int v = arr[1];
            int w = arr[2];

            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        long[] ways = new long[n];

        dist[0] = 0;
        ways[0] = 1;

        int mod = (int)1e9 + 7;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.second,b.second));

        pq.offer(new Pair(0,0));

        while(!pq.isEmpty()){

            Pair curr = pq.poll();

            int node = curr.first;
            long weight = curr.second;

            if(weight > dist[node]) continue;

            for(Pair it : adj.get(node)){

                int next = it.first;
                long newDist = weight + it.second;

                if(newDist < dist[next]){

                    dist[next] = newDist;
                    pq.offer(new Pair(next,newDist));
                    ways[next] = ways[node];

                }

                else if(newDist == dist[next]){

                    ways[next] = (ways[next] + ways[node]) % mod;

                }

            }
        }

        return (int)(ways[n-1] % mod);
    }
}