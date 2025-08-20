class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] arr : flights) {
            int u = arr[0], v = arr[1], w = arr[2];
            adj.get(u).add(new Pair(v, w));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Tuple> pq = new LinkedList<>();
        pq.offer(new Tuple(src, 0, 0)); // node, stops, cost

        while (!pq.isEmpty()) {
            Tuple curr = pq.poll();
            int node = curr.s;
            int stops = curr.d;
            int cost = curr.price;

            if (stops > k) continue; // can't exceed K stops

            for (Pair it : adj.get(node)) {
                int next = it.node;
                int newCost = cost + it.price;

                if (stops<=k && newCost < dist[next]) {
                    dist[next] = newCost;
                    pq.offer(new Tuple(next, stops + 1, newCost));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}

class Pair {
    int node, price;
    public Pair(int node, int price) {
        this.node = node;
        this.price = price;
    }
}

class Tuple {
    int s, d, price;
    public Tuple(int s, int d, int price) {
        this.s = s;     // node
        this.d = d;     // stops
        this.price = price; // cost so far
    }
}
