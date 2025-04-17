class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] temp : flights) {
            int s = temp[0];
            int d = temp[1];
            int price = temp[2];
            adj.get(s).add(new int[]{d, price});
        }

        // PriorityQueue sorts by cost
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.price - b.price);
        pq.add(new Tuple(src, 0, 0));

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        stops[src] = 0;

        while (!pq.isEmpty()) {
            Tuple curr = pq.poll();
            int node = curr.node;
            int price = curr.price;
            int stop = curr.stops;

            if (node == dst) return price;
            if (stop > k) continue;

            for (int[] neighbor : adj.get(node)) {
                int next = neighbor[0];
                int nextPrice = neighbor[1];

                // Only push to queue if we haven’t already reached this node in fewer stops
                if (stop + 1 <= k + 1 && stop + 1 < stops[next]) {
                    stops[next] = stop + 1;
                    pq.add(new Tuple(next, price + nextPrice, stop + 1));
                }
            }
        }

        return -1;
    }

    class Tuple {
        int node, price, stops;
        public Tuple(int node, int price, int stops) {
            this.node = node;
            this.price = price;
            this.stops = stops;
        }
    }
}
