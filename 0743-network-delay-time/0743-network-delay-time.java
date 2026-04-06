class Solution {
    public class Pair {
        int node;
        int time;

        public Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {   
            adj.add(new ArrayList<>());
        }

        for (int[] row : times) {
            int u = row[0];
            int v = row[1];
            int t = row[2];
            adj.get(u).add(new Pair(v, t));
        }

        int[] dist = new int[n + 1];   
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;                  
        int[] vis = new int[n + 1];  
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.offer(new Pair(k, 0));

        int t = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int time = curr.time;

            if (vis[node] == 1) continue; 
            vis[node] = 1;

            t = time;

            for (Pair next : adj.get(node)) {
                int nextNode = next.node;
                int nextTime = next.time;
                if (vis[nextNode] == 0 && dist[node] + nextTime < dist[nextNode]) {
                    dist[nextNode] = dist[node] + nextTime;
                    pq.offer(new Pair(nextNode, dist[nextNode]));
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (vis[i] == 0) return -1;
        }

        return t;
    }
}