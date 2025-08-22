class Solution {
    public boolean canFinish(int n, int[][] preq) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int ans = 0;
        int[] indeg = new int[n];

        for (int[] arr : preq) {
            int course = arr[0];
            int pre = arr[1];
            adj.get(pre).add(course);
            indeg[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            ans++;
            for (int next : adj.get(curr)) {
                indeg[next]--;
                if (indeg[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return ans == n;
    }
}
