import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        long[] ways = new long[n];
        int MOD = (int)1e9 + 7;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int) curr[0];
            long d = curr[1];

            if (d > dist[node]) continue; // Skip outdated entries

            for (int[] it : adj.get(node)) {
                int next = it[0];
                long nd = d + it[1];

                if (nd < dist[next]) {
                    dist[next] = nd;
                    pq.offer(new long[]{next, nd});
                    ways[next] = ways[node] % MOD;
                } else if (nd == dist[next]) {
                    ways[next] = (ways[next] + ways[node]) % MOD;
                }
            }
        }

        return (int)(ways[n - 1] % MOD);
    }
}
