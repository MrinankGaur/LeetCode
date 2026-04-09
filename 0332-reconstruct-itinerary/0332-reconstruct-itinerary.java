import java.util.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();

        // Build graph
        for (List<String> t : tickets) {
            String src = t.get(0);
            String dest = t.get(1);

            adj.computeIfAbsent(src, k -> new PriorityQueue<>()).add(dest);
        }

        List<String> result = new ArrayList<>();
        dfs("JFK", adj, result);

        Collections.reverse(result);
        return result;
    }

    private void dfs(String src, Map<String, PriorityQueue<String>> adj, List<String> result) {
        PriorityQueue<String> pq = adj.get(src);

        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll(), adj, result);
        }

        result.add(src);
    }
}