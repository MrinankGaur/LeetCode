class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int n = numCourses;
        int[] indeg = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:prerequisites){
            indeg[edge[1]]++;
            adj.get(edge[0]).add(edge[1]);
        }
        List<Set<Integer>> pre = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pre.add(new HashSet<>());
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
         while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                pre.get(v).add(u);
                pre.get(v).addAll(pre.get(u));
                indeg[v]--;
                if (indeg[v] == 0) {
                    q.offer(v);
                }
            }
        }
       List<Boolean> ans = new ArrayList<>();
        for (int[] qy : queries) {
            ans.add(pre.get(qy[1]).contains(qy[0]));
        }
        return ans;
    }
}